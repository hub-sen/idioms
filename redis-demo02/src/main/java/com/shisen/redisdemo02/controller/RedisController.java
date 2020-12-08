package com.shisen.redisdemo02.controller;

import com.shisen.redisdemo02.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/8 16:48
 * </pre>
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${server.port}")
    private String serverPort;

    private final String redisKey = "goods:001";
    private final String redisLock = "buyLock";

    @GetMapping("buy")
    public String buy() throws Exception {
        String value = UUID.randomUUID() + Thread.currentThread().getName();

        try {
            Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(redisKey, value, 10L, TimeUnit.SECONDS);

            if (!ifAbsent) {
                return "抢锁失败";
            }

            String result = redisTemplate.opsForValue().get(redisKey);
            int goodNumber = null == result ? 0 : Integer.parseInt(result);
            if (0 < goodNumber) {
                int realNumber = goodNumber - 1;
                redisTemplate.opsForValue().set(redisKey, String.valueOf(realNumber));
                System.out.println("成功购买商品, 库存剩余 = " + realNumber + "\tserverPort= " + serverPort);
                return "成功购买商品, 库存剩余 = " + realNumber + "serverPort= " + serverPort;
            } else {
                System.out.println("商品售罄\t serverPort= " + serverPort);
            }

            return "商品售罄\t serverPort= " + serverPort;
        } finally {
            Jedis jedis = RedisUtils.getJedis();

            String script = "if redis.call('get',KEYS[1]) == ARGV[1]" +
                    "then" +
                    "return redis.call('del',KEYS[1])" +
                    "else" +
                    "    return 0" +
                    "end";
            try {
                Object eval = jedis.eval(script, Collections.singletonList(redisLock), Collections.singletonList(value));
                if ("1".equals(eval.toString())) {
                    System.out.println("delete redisLock ok");
                } else {
                    System.out.println("delete redisLock not ok");
                }
            } finally {
                if (null != jedis) {
                    jedis.close();
                }
            }
        }
    }
}
