package com.shisen.idioms.testJdk;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/19 17:16
 * </pre>
 */
@Data
public class AppNavigationParamsRequest {
    private BigDecimal x = BigDecimal.valueOf(40);
    private BigDecimal y = BigDecimal.valueOf(22.2);
}
