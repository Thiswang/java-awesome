/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package 创建型模式.singleton;

/**
 * @author wangzhe 2018/4/22.
 */
public class SingletonLazy {
    private static volatile SingletonLazy singletonLazy;

    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            synchronized (SingletonLazy.class) {
                if (singletonLazy == null) {
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;

    }
}
