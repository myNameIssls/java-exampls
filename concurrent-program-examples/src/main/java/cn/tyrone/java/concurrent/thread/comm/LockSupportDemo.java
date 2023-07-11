package cn.tyrone.java.concurrent.thread.comm;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "正在执行");
            System.out.println(Thread.currentThread().getName() + "\t" + "进入等待状态");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "继续执行");
        });
        a.start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t" + "正在执行");
            System.out.println(Thread.currentThread().getName() + "\t" + "唤醒等待线程");
            LockSupport.unpark(a);
        }).start();


    }

}
