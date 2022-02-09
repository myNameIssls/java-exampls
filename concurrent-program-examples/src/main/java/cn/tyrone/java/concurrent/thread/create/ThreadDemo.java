package cn.tyrone.java.concurrent.thread.create;

/**
 * 线程创建方式一:
 * 1. 继承Thread类
 * 2. 重写run方法，将并发逻辑写在run方法内
 */
public class ThreadDemo extends Thread{

    // 编写并发逻辑
    @Override
    public void run() {
//        synchronized (ThreadDemo.class) {
            for (int i = 0; i < 5; i++) {
                String name = Thread.currentThread().getName();
                System.out.println("当前线程名称：" + name);
            }
//        }
    }

    // 测试
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Thread thread = new ThreadDemo();
            thread.start();
        }
    }

}
