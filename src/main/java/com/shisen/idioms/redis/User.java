package com.shisen.idioms.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/11/11 17:53
 * </pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String uid = UUID.randomUUID().toString();
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
