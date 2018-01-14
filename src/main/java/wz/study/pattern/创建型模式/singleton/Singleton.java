/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package wz.study.pattern.创建型模式.singleton;

/**
 * @author wangzhe 2017/12/26.
 */
public class Singleton {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 *//*
    private static Singleton instance = null;

    *//* 私有构造方法，防止被实例化 *//*
    private Singleton() {
    }

    *//* 静态工程方法，创建实例 *//*
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }*/


    /**
     * 这个不会有线程安全的问题,单例模式的 dubble check写法也会有线程安全问题
     */
    private static Singleton instance = new Singleton();

    private Singleton() {
    }
    public static Singleton getInstance() {
        return Singleton.instance;
    }

}
