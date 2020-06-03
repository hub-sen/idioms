package com.shisen.idioms.feng;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/28 14:10
 * </pre>
 */
public class App {


    private List<LockPassword> lockPasswords = new ArrayList<>();


    @Before
    public void before() {

        lockPasswords.add(new LockPassword(1, 1));
        lockPasswords.add(new LockPassword(2, 1));
        lockPasswords.add(new LockPassword(2, 2));
        lockPasswords.add(new LockPassword(1, 2));
        lockPasswords.add(new LockPassword(1, 3));

    }

    @Test
    public void getLockPassword() {

        Map<Integer, LockPassword> collect = lockPasswords.stream()
                .collect(Collectors.toMap(LockPassword::getProductId, Function.identity(), (existing, replacement) -> existing
                        .getId() > replacement.getId() ? existing : replacement));

        System.out.println("collect = " + collect);


    }



}
