package com.cowboy.test.spel;/**
 * Created by Administrator on 2017/12/21/0021.
 */

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-21 15:09
 **/
public enum SpEnum {
    RED("hehe ...red");
    private String name;

    SpEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
