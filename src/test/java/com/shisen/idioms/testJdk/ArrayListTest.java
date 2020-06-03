package com.shisen.idioms.testJdk;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/3/26 17:27
 * </pre>
 */
public class ArrayListTest {

    @Test
    public void testNewArrayListWithNull() {
        ArrayList<String> strings = new ArrayList<>(1);

        strings.add("x");
        strings.add("x");
        strings.add("x");
        System.out.println("strings = " + strings.size());
    }

    @Test
    public void testBigDecimal() {
        String s = String.format("%.2f", ThreadLocalRandom.current().nextDouble(1, 20000));
        System.out.println("s = " + s);

        BigDecimal bigDecimal = new BigDecimal(12.4465655654);
        System.out.println("bigDecimal = " + bigDecimal);

        System.out.println(bigDecimal.setScale(6, RoundingMode.HALF_UP)+","+bigDecimal.setScale(6, RoundingMode.HALF_UP));


        AppNavigationParamsRequest appNavigationParamsRequest = new AppNavigationParamsRequest();

        String s1 = JSONObject.toJSONString(appNavigationParamsRequest);
        System.out.println("s1 = " + s1);


    }

}
