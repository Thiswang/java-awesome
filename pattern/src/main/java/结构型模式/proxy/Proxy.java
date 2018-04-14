/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package 结构型模式.proxy;

/**
 * @author wangzhe 2017/12/28.
 */
public class Proxy implements Sourceable {

    private Source source;
    public Proxy(){
        super();
        this.source = new Source();
    }
    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }
    private void atfer() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }
}