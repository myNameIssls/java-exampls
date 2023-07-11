package cn.tyrone.java.concurrent.thread.comm;

public class ObjectWaitNotify {

    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(()->{
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "正在执行");
                try {
                    System.out.println(Thread.currentThread().getName() + "\t" + "进入等待状态");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "继续执行");
            }
        }).start();

        new Thread(()->{
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "正在执行");
                lock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "唤醒等待线程");
            }
        }).start();

    }

}
