package com.shisen.idioms.js;

import java.math.BigDecimal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/28 13:29
 * </pre>
 */
public abstract class AbstractStrategy implements IStrategy {

    protected BigDecimal price;

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
