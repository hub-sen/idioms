package com.shisen.redisdemo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("buy")
    public String buy() {
        synchronized (this) {
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
        }
    }
}
