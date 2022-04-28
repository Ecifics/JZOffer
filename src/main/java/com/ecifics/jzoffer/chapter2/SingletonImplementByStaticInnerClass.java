package com.ecifics.jzoffer.chapter2;

/**
 * @author Ecifics
 * @Description 通过静态内部类来实现Singleton模式
 * @date 4/28/2022-9:40 AM
 */
public class SingletonImplementByStaticInnerClass {

    private SingletonImplementByStaticInnerClass() {}

    private static class NestedClass {
        public static SingletonImplementByStaticInnerClass INSTANCE
                = new SingletonImplementByStaticInnerClass();
    }

    public SingletonImplementByStaticInnerClass getInstance() {
        return NestedClass.INSTANCE;
    }
}
