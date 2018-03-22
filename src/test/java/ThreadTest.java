/**
 * Copyright (C), 2011-2018, 微贷网.
 */

/**
 * @author wangzhe 2018/2/2.
 */
public class ThreadTest implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"start...");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"finish...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new ThreadTest());
        Thread t2 = new Thread(new ThreadTest());

        t1.start();
        t2.start();
        System.out.println(123);
        t1.join();
        System.out.println(1231);
        t2.join();
        System.out.println(1232);

    }
}
