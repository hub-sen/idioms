package com.shisen.idioms.js;

import com.shisen.idioms.IdiomsApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/28 13:34
 * </pre>
 */
public class App extends IdiomsApplicationTests {

    @Resource
    private ApplicationContext applicationContext;

    private static Map<String, Function<BigDecimal, IStrategy>> map = new HashMap<>();

    private static Map<String, IStrategy> beansOfType;

    @Before
    public void before() {

        map.put("A", AStrategy::new);
        map.put("B", BStrategy::new);
        map.put("C", CStrategy::new);

        beansOfType = applicationContext.getBeansOfType(IStrategy.class);


    }

    IStrategy getStrategy(String key, BigDecimal price) throws Exception {
        Function<BigDecimal, IStrategy> strategyFunction = map.get(key);
        if (Objects.nonNull(strategyFunction)) {
            return strategyFunction.apply(price);
        }
        throw new Exception("不支持的策略类型");
    }


    @Test
    public void test_1() {
        try {
            IStrategy aStrategy = getStrategy("A", BigDecimal.TEN);
            String aStrategyJson = aStrategy.toJsonString();
            System.out.println("aStrategyJson = " + aStrategyJson);
            IStrategy bStrategy = getStrategy("B", BigDecimal.ZERO);
            String bStrategyJson = bStrategy.toJsonString();
            System.out.println("bStrategyJson = " + bStrategyJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_2() {
        System.out.println("beansOfType = " + beansOfType);
    }


    @Test
    public void test_3() {
        IStrategy a = IStrategy.of("A");

        System.out.println("a = " + a);

    }


}
