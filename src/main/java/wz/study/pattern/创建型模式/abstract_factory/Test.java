/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package wz.study.pattern.创建型模式.abstract_factory;

/**
 * @author wangzhe 2017/12/26.
 */


/**
 * 优点
 * 1 控制了新对象的创建过程，将对象的创建统一起来便于维护和整体把控
 *  场景1：某个对象被new了100次，之后因为逻辑改动多了一个参数，如果不使用工厂模式就需要修改这100个new新对象的地方
 *  场景2：创建这些对象时加以控制，比如可以进行aop，事务等等加工（spring）
 *
 * 2 开闭原则（thinking）
 */
public class Test   {
    public static void main(String[] args) {
        Factory factory = new SendMailFactory();
        Sender sender = factory.produce();
        sender.Send();
    }
}
