package com.abel.redisaction.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xufeng
 * @since 2020/12/23
 */
@Data
public class User implements Serializable {

    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User() {
    }
}
