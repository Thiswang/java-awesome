/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package wz.study.jdk.classloader;

/**
 * @author wangzhe 2018/3/22.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value =123;

    public static final String strValue="heiheiheihei";
}
