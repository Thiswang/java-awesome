/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package 结构型模式.adapter.类的适配器模式;

/**
 * @author wangzhe 2017/12/27.
 */
public interface Targetable {
    /* 与原类中的方法相同 */
    public void method1();

    /* 新类的方法 */
    public void method2();
}
