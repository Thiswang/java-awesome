/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package wz.study.pattern.结构型模式.decorator;

/**
 * @author wangzhe 2017/12/28.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
