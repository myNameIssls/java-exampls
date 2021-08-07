package cn.tyrone.javase.multithreading.helloword;

/**
 * 这个类是通过继承Thread来实现多继承的
 */
public class ThreadDemo extends Thread {

    /**
     * 重写run方法
     */
    @Override
    public void run() {
        System.out.println("ThreadDemo:" + Thread.currentThread().getName());
    }

}
