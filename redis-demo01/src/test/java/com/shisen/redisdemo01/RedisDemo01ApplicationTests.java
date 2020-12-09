package com.shisen.redisdemo01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisDemo01ApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }


    @Test
    public void setRedis() {
        String s = redisTemplate.opsForValue().get("goods:001");
        System.out.println("s = " + s);
        redisTemplate.opsForValue().set("goods:001", String.valueOf(1000000));
    }

}
