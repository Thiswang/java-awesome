/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package 结构型模式.adapter.对象的适配器模式;

/**
 * @author wangzhe 2017/12/27.
 */
public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source){
        super();
        this.source = source;
    }
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}
