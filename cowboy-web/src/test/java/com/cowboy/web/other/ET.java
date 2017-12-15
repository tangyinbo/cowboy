package com.cowboy.web.other;/**
 * Created by Administrator on 2017/12/15/0015.
 */

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-15 10:09
 **/
public class ET {
    private String name = initName();

    private int age;

    public ET(int age) {
        System.out.println("constructor init");
        this.age = age;
    }

    public String initName(){
        System.out.println("field init");
        return "tangyinbo";
    }

    public static void main(String[] args) {
        ET et = new ET(12);
    }


}
