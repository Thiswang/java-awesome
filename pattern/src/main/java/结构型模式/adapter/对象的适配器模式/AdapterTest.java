/*
 * Copyright (C), 2011-2017, 微贷网.
 */
package 结构型模式.adapter.对象的适配器模式;

/**
 * @author wangzhe 2017/12/27.
 * 对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
 */
public class AdapterTest {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}
