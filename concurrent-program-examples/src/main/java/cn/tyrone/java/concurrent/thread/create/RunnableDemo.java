package cn.tyrone.java.concurrent.thread.create;

/**
 * 创建线程的方式二：
 * 实现Runnable接口，并实现run方法，
 */
public class RunnableDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String name = Thread.currentThread().getName();
            System.out.println("当前线程名称：" + name);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
    }

}
