/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package 结构型模式.proxy;

/**
 * @author wangzhe 2017/12/28.
 */
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}