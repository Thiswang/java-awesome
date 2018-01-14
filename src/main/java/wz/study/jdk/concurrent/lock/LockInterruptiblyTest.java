/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package wz.study.jdk.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangzhe 2018/1/11.
 */
public class LockInterruptiblyTest implements Runnable{

    private Lock lock;

    public LockInterruptiblyTest(String name, Lock lock) {
        this.lock = lock;
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
        System.out.println(Thread.currentThread().getName()+"得到了锁");
        try {
            Thread.sleep(1002);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for(int i = 0;i<10;i++)
        {
            Thread t = new Thread(new LockInterruptiblyTest(i+"",lock));
            t.start();
        }
    }
}
