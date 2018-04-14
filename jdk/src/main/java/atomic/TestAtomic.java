package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    public static AtomicInteger A = new AtomicInteger(0);// 所有的线程操作同一个对象
    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("A累计前" + TestAtomic.A + ",i累计前：" + TestAtomic.i);
        Thread t0 = new Thread(
                new Runnable() {

                    @Override
                    public void run() {
                        for (int j = 0; j < 10000; j++) {

                            TestAtomic.i++;
                            TestAtomic.A.getAndIncrement();
                        }
                    }
                });
        Thread t1 = new Thread(
                new Runnable() {

                    @Override
                    public void run() {
                        for (int j = 0; j < 10000; j++) {

                            TestAtomic.i++;
                            TestAtomic.A.getAndIncrement();
                        }
                    }
                });
        t0.start();
        t1.start();
        t0.join();
        t1.join();

        System.out.print("A累计后" + TestAtomic.A + ",i累计后：" + TestAtomic.i);

    }
}
