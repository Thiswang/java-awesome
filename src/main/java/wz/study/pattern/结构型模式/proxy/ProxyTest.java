/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package wz.study.pattern.结构型模式.proxy;

/**
 * @author wangzhe 2017/12/28.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }

}