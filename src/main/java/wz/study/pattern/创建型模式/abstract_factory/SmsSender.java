/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package wz.study.pattern.创建型模式.abstract_factory;

/**
 * @author wangzhe 2017/12/26.
 */
public class SmsSender implements Sender{
    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
