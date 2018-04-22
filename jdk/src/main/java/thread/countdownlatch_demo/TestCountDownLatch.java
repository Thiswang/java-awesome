/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package thread.countdownlatch_demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangzhe 2018/4/19.
 */
public class TestCountDownLatch {public static void main(String[] args) {
    final CountDownLatch latch = new CountDownLatch(2);



    new Thread(){
        public void run() {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }.start();

    new Thread(){
        public void run() {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }.start();

    try {
        System.out.println("等待2个子线程执行完毕...");
        latch.await();
        System.out.println("2个子线程已经执行完毕");
        System.out.println("继续执行主线程");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}
