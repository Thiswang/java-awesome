/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package 创建型模式.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhe 2017/12/26.
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }
}
