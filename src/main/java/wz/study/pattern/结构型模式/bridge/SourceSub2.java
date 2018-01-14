/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package wz.study.pattern.结构型模式.bridge;

/**
 * @author wangzhe 2018/1/10.
 */
public class SourceSub2 implements Sourceable {

    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }
}