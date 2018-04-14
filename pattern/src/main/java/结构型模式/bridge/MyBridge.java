/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package 结构型模式.bridge;

/**
 * @author wangzhe 2018/1/10.
 */
public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}