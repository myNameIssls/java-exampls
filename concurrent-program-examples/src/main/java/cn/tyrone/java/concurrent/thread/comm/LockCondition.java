package cn.tyrone.java.concurrent.thread.comm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{

            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t" + "正在执行");
            System.out.println(Thread.currentThread().getName() + "\t" + "进入等待状态");
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "继续执行");

        }).start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "正在执行");
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "唤醒等待线程");
            } finally {
                lock.unlock();
            }
        }).start();

    }

}
