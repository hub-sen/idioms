package com.shisen.idioms.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreferentialRange implements Serializable {
    private static final long serialVersionUID = -9080503069607871592L;
    int rangeStart;
    int rangeEnd;
    BigDecimal preferentialPrice;

    /**
     * 张数
     */
    int couponCount;


    /**
     * 优惠券名称
     */
    String couponName;

    /**
     * 有效时长(单位: 天)
     */
    int effectiveTime;

    /**
     * [rangeStart, rangeEnd)
     * @param count
     * @return
     */
    boolean inRange(int count) {
        return rangeStart <= count && count < rangeEnd;
    }
}