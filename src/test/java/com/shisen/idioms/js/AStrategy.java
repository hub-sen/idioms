package com.shisen.idioms.js;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/28 13:28
 * </pre>
 */
@Setter
@Getter
@Service
public class AStrategy extends AbstractStrategy {

    public AStrategy() {
    }

    public AStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price.add(BigDecimal.ONE);
    }

}
