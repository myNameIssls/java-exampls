package cn.tyrone.javase.multithreading.helloword;

/**
 * 测试类
 *
 */
public class ThreadTest {

	public static void main(String[] args) {
		
		System.out.println("--- 主线程，开启新线程之前 ---");
		
		ThreadDemo thread = new ThreadDemo();
		thread.setName("thread-demo");
		thread.start(); // 启动线程
		
		System.out.println("--- 主线程，开启第一个线程 ---");
		
		ThreadRunnable runnable = new ThreadRunnable();
		Thread thread1 = new Thread(runnable, "thread-runnable");
		thread1.start();
		
		System.out.println("--- 主线程，开启第二个线程 ---");
		
	}

}
