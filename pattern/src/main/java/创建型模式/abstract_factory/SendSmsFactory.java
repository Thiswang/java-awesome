/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package 创建型模式.abstract_factory;

/**
 * @author wangzhe 2017/12/26.
 */
public class SendSmsFactory implements Factory {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
