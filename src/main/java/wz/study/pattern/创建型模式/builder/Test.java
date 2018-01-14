/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package wz.study.pattern.创建型模式.builder;

/**
 * @author wangzhe 2017/12/26.
 */
public class Test {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }

}
