package com.shisen.idioms.hutool;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/7 14:49
 * </pre>
 */
@Data
@AllArgsConstructor
public class TCCost {
    private String plateNo;
    private BigDecimal cost;
}
