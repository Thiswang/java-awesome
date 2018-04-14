/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package 创建型模式.builder;

/**
 * @author wangzhe 2017/12/26.
 */
public class MailSender implements Sender{
    @Override
    public void Send() {
        System.out.println("this is mail sender!");
    }
}
