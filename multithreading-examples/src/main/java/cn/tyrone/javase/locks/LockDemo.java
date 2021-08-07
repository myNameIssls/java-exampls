package cn.tyrone.javase.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        final Count ct = new Count();

        for (int i = 0 ; i < 2 ;i ++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ct.get();
                }
            }).start();
        }

        for (int i = 0 ; i < 2 ;i ++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ct.put();
                }
            }).start();
        }

    }

    static class Count {

        final ReentrantLock lock = new ReentrantLock();

        public void get() {
//            final ReentrantLock lock = new ReentrantLock();
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "get begin!");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + "get end!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void put() {
//            final ReentrantLock lock = new ReentrantLock();
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "put begin");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + "put end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

}
