/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package wz.study.jdk.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangzhe 2018/1/11.
 */
public class LockTest implements Runnable{

    private Lock lock;

    public LockTest(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"得到了锁");
        try {
            Thread.sleep(1001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args)  {

        Lock lock = new ReentrantLock();
        for(int i = 0;i<10;i++)
        {
            Thread t = new Thread(new LockTest(lock),"Thread-"+i);
            t.start();
        }
    }
}
