/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package classloader;

/**
 * @author wangzhe 2018/3/22.
 */
public class DeadLoopClass {
    static {
        /*如果不加上if，编译器会提示报错*/
        if (true) {
            System.out.println(Thread.currentThread() + "init DeadLoopClass");
            while (true) {

            }
        }
    }

}
