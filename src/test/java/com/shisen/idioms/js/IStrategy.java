package com.shisen.idioms.js;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/28 13:22
 * </pre>
 */
public interface IStrategy {

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    default String toJsonString(){
        return JSONObject.toJSONString(this);
    }

    static IStrategy of(String type){
        if (StringUtils.isBlank(type)) {
            throw new RuntimeException("不支持的类型");
        }
        switch (type) {
            case "A":
                return new AStrategy();
            case "B":
                return new BStrategy();
            case "C":
                return new CStrategy();
            default:
                throw new RuntimeException("不支持的类型");
        }
    }
}
