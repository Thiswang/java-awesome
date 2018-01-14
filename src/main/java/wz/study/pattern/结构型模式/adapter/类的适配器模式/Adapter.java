/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package wz.study.pattern.结构型模式.adapter.类的适配器模式;

/**
 * @author wangzhe 2017/12/27.
 */
public class Adapter extends Source implements Targetable{
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
