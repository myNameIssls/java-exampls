package cn.tyrone.javase.multithreading;

/**
 * 这个类主要是编写创建线程的两种方式：
 * 第一种方式：
 * 	1. 继承Thread类，并重写run方法
 * 	2. 调用start()方法启动该线程
 * 第二种方式：
 * 	1. 实现Runnable接口，并实现run()方法
 *  2. 2. 调用start()方法启动该线程
 *
 */
public class TranditionalThread {

	public static void main(String[] args) {
		
		System.out.println("---- 启用第一个线程之前 ----");
		
		Thread thread = new Thread("thread1") {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		thread.start();
		
		System.out.println("---- 启用第二个线程之前 ----");
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}, "Runnable-thread");
		
		thread2.start();
		
		System.out.println("---- 线程结束 ----");
		
	}
	
}
