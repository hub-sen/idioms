package com.shisen.guava;

import com.google.common.collect.ComparisonChain;
import lombok.Data;
import org.junit.Test;

import java.util.Objects;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/9/7 17:02
 * </pre>
 */
@Data
public class ObjectsTest implements Comparable<ObjectsTest> {

    private String name;
    private int age;


    @Test
    public void test01() {


        boolean a = Objects.equals("a", null);
        System.out.println("a = " + a);
    }

    @Override
    public int compareTo(ObjectsTest that) {
        return ComparisonChain.start()
                .compare(this.getAge(),that.getAge())
                .compare(this.getName(),that.getName())
                .result();
    }
}
