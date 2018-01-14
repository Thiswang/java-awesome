/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package wz.study.pattern.结构型模式.bridge;

/**
 * @author wangzhe 2018/1/10.
 */
public abstract class Bridge {
    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}