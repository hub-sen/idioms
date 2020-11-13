package com.shisen.idioms.redis;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/11/11 17:52
 * </pre>
 */
@RestController
@Slf4j
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private User user = new User("1", "shishi", 24);

    @GetMapping("set/{name}/{age}")
    public void set(@PathVariable("name") String name, @PathVariable("age") int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        log.info("set user info: {}", JSONUtil.toJsonStr(user));
        redisTemplate.opsForValue().set(user.getUid(), user);
    }

    @GetMapping("get/{uid}")
    public User get(@PathVariable("uid") String uid) {
        return (User) redisTemplate.opsForValue().get(uid);
    }

    /**
     * 签到
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    @PostMapping("sign/{year}/{month}/{day}")
    public Boolean sign(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day") int day) {
        log.info("签到, user: {}, date: {}", user.getUid(), String.format("%s/%s/%s", year, month, day));
        return redisTemplate.opsForValue()
                .setBit(buildSignKey(user.getUid(), year, month), day - 1, true);
    }

    /**
     * 是否签到
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    @GetMapping("getSign/{year}/{month}/{day}")
    public Boolean getSign(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day") int day) {
        return redisTemplate.opsForValue().getBit(buildSignKey(user.getUid(), year, month), day - 1);
    }

    /**
     * 签到次数
     *
     * @param year
     * @param month
     * @return
     */
    @GetMapping("getSignCount/{year}/{month}")
    public long getSignCount(@PathVariable("year") int year, @PathVariable("month") int month) {
        return redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(buildSignKey(user.getUid(), year, month).getBytes()));
    }

    @GetMapping("getSignList/{year}/{month}")
    public List<String> getSignListIntelligent(@PathVariable("year") int year, @PathVariable("month") int month) {
        LocalDate now = LocalDate.now();

        int nowYear = now.getYear();
        int nowMonthValue = now.getMonthValue();

        if (year > nowYear || (year == nowYear && month > nowMonthValue)) {
            return null;
        } else if (year == nowYear && month == nowMonthValue) {
            return getSignList(buildSignKey(user.getUid(), year, month), now, now.getDayOfMonth());
        } else {
            LocalDate parse = LocalDate.of(year, month, 1);
            return getSignList(buildSignKey(user.getUid(), year, month), parse, parse.lengthOfMonth());
        }

    }

    @PostMapping("setStr/{str}")
    public void setStr(@PathVariable("str") String str) {
        int index = 0;
        for (int i = 0, lengthI = str.length(); i < lengthI; i++) {
            char c = str.charAt(i);
            String s = "0" + Integer.toBinaryString(c);

            for (int j = 0, lengthJ = s.length(); j < lengthJ; j++) {
                if (s.charAt(j) == '1') {
                    System.out.println(index);
                    redisTemplate.opsForValue().setBit(str, index, true);
                }
                index++;
            }
        }
    }


    private List<String> getSignList(String key, LocalDate parse, int limit, int offset) {
        List<Long> longs = bitField(key, limit, offset);

        List<String> result = new ArrayList<>();

        if (CollectionUtil.isNotEmpty(longs)) {
            long sign = null == longs.get(0) ? 0 : longs.get(0);
            for (int i = limit; i > 0; i--, sign >>= 1) {
                result.add(String.format(("%tF %s"), parse.withDayOfMonth(i), 1 == (sign & 1)));
            }
        }

        return result;
    }

    private List<String> getSignList(String key, LocalDate parse, int limit) {
        return getSignList(key, parse, limit, 0);
    }

    private List<Long> bitField(String key, int limit, int offset) {
        return redisTemplate.opsForValue().bitField(key, BitFieldSubCommands.create()
                .get(BitFieldSubCommands.BitFieldType.unsigned(limit))
                .valueAt(offset));
    }

    /**
     * 获取key
     *
     * @param uid
     * @param year
     * @param month
     * @return
     */
    private String buildSignKey(String uid, int year, int month) {
        return String.format("sign:%s:%d%d", uid, year, month);
    }
}
