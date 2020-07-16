package com.wz;

/**
 * @author 隔壁老王
 * @create 2020-07-12 9:47
 * @微信公众号 隔壁老王说Java
 * @description
 */
public class Cat {
    private String name;
    private Mouse friend;

    public Cat() {
    }

    public Cat(String name, Mouse friend) {
        this.name = name;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mouse getFriend() {
        return friend;
    }

    public void setFriend(Mouse friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }
}
