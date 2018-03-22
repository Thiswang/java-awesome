/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package wz.study.jdk.classloader;

/**
 * @author wangzhe 2018/3/22.
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }

}
