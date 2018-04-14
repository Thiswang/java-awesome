/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangzhe 2018/1/11.
 */
public class TryLockTest implements Runnable{

    private Lock lock;

    public TryLockTest(String name, Lock lock) {
        this.lock = lock;
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        if (lock.tryLock())
        {
            System.out.println(Thread.currentThread().getName()+"得到了锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+"释放了锁");
                lock.unlock();

            }
        }else{
            System.out.println(Thread.currentThread().getName()+"获取锁失败");
        }
    }


    public static void main(String[] args)  {

        Lock lock = new ReentrantLock();
        for(int i = 0;i<10;i++)
        {
            Thread t = new Thread(new TryLockTest(i+"",lock));
            t.start();
        }
    }
}
