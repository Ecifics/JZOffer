# 实现Singleton模式
[TOC]

## 一、概述
单例模式定义：确保一个类只有一个实例，并提供一个全局访问点来访问这唯一实例

## 二、总体思路
既然一个类只能有一个实例，那么必须保证构造方法为私有方法，并提供一个公共方法来获取类的唯一实例

## 三、解法
### 3.1 解法一：只适用于单线程
#### 3.1.1 代码
```java
public class Singleton {

    /**
     * 单例对象
     */
    private static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }
}
```
#### 3.1.2 分析
上述代码只适合单线程环境，如果多线程同时调用`getInstance`方法，可能会出现多个线程在if判断的时候，单例对象没有创建好，而进入到if语句类创建多个单例对象

### 3.2 解法二：适用于多线程环境，性能差
#### 3.2.1 代码
```java
public class Singleton {

    /**
     * 单例对象
     */
    private static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
        }

        return INSTANCE;
    }
}
```

#### 3.2.2 分析
在这种方式下，多线程访问，必须获得锁，且还未创建实例对象时，才能创建唯一实例对象

但是这也为之后的使用造成了麻烦，即使之前已经创建好了实例化对象，但每次调用`getInstance`方法都需要获取锁，获取锁的过程是上下文切换，速度非常慢，造成了不必要的性能损失，那么如何优化这段代码呢？

### 3.3 解法三：适合多线程代码，double-check locking
#### 3.3.1 代码
```java
public class Singleton {

    /**
     * 单例对象
     */
    private static Singleton INSTANCE;

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
```
#### 3.3.2 分析
相较于解法二，在同步锁前后两次判断实例是否存在，如果实例已存在，那么线程该不会进入到if语句中，大大减少了等待锁而造成的性能损失

如果未创建实例，即使有多个线程进入了第一个if语句，但是也只能有一个获得锁创建实例，释放锁后其他线程进入同步语句，第二个if语句会将这些线程挡在外面，不会在创建新的实例对象

### 3.4 解法四：利用静态内部类
#### 3.4.1 代码
```java
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
```

#### 3.4.2 分析
因为静态成员变量是属于类的，不属于任何一个对象，因此所有实例对象共享同一个静态成员变量

在本例中，静态内部内`NestedClass`中的INSTANCE就是静态成员变量，它是唯一的，通过这种方式可以达到按需调用






