package com.wz;

/**
 * @author 隔壁老王
 * @create 2020-07-12 9:45
 * @微信公众号 隔壁老王说Java
 * @description
 */
public class Mouse {
    private String name;

    public Mouse() {
    }

    public Mouse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                '}';
    }
}
