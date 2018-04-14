/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package 结构型模式.adapter.接口的适配器模式;

/**
 * @author wangzhe 2017/12/27.
 */
public class SourceSub1 extends Wrapper2 {
    public void method1(){
        System.out.println("the sourceable interface's first Sub1!");
    }
}