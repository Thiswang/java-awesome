/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package classloader;

/**
 * @author wangzhe 2018/3/22.
 */
public class MainClass {
    public static void main(String[] args) {


        //System.out.println(SubClass.value);

        //SuperClass[] sca = new SubClass[10];

        //System.out.println(SubClass.strValue);

        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "end");
            }
        };

        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
    }
}







