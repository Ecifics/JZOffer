package com.ecifics.jzoffer.chapter2;

/**
 * @author Ecifics
 * @Description 剑指offer第二题
 * @date 4/27/2022-4:16 PM
 */
public class Singleton {

    /**
     * 单例对象
     */
    private volatile static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }
}
