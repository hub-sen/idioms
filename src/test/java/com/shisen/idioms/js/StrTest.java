package com.shisen.idioms.js;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/17 13:32
 * </pre>
 */
public class StrTest {

    private enum Season {
        WD("WD", "晚点"), CC("CC", "查车"), DC("DC", "堵车");

        private String code;
        private String value;

        Season(String code, String value) {
            this.code = code;
            this.value = value;
        }


        public static Season getSeasonByCode(String code) {
            for (Season season : Season.values()) {
                if (season.code.equals(code)) {
                    return season;
                }
            }
            return null;
        }

    }


    private String reason = "WD:4,CC:2,DC:1,DC";

    private String reason1 = "WD,CC,DC,DC";

    @Test
    public void transEvaluateReason() {
        String collect = Arrays.stream(reason1.split(","))
                .map(x -> {
                    String[] split = x.split(":");

                    Season seasonByCode = Season.getSeasonByCode(split[0]);

                    if (Objects.isNull(seasonByCode)) {
                        return null;
                    }

                    String result = seasonByCode.value;
                    if (split.length > 1) {
                        result += ":" + split[1] + "H";
                    }

                    return result;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.joining(","));
        System.out.println("collect = " + collect);
    }

    @Test
    public void testJson() {
        String jsonStr = "";
    }
    
    @Test
    public void test_1() {
        BigDecimal zero = BigDecimal.TEN;



        System.out.println("zero = " + zero.doubleValue());


        System.out.println("zero.compareTo(BigDecimal.ZERO) = " + zero.compareTo(BigDecimal.ZERO));



        if (zero.doubleValue() > 0) {
            System.out.println("hello");
        }

    }



}
