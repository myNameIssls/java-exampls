package cn.tyrone.javase.interviewcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadWaitNotify2 {
	private volatile List list = new ArrayList();
	
	public void add(){
		list.add("tyrone");
	}
	
	public int size(){
		return list.size();
	}
	
	public static void main(String[] args) {
		final ThreadWaitNotify2 twn = new ThreadWaitNotify2();
		
		Object lock = new Object();
		
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
//				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						twn.add();
						System.out.println("当前线程: " + Thread.currentThread().getName() + "添加了一个元素！");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						if (twn.size() == 5) {
							System.out.println("已经发出通知。。。。");
//							lock.notify();
							countDownLatch.countDown();
						}
						
					}
//				}
				
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
//				synchronized (lock) {
					if (twn.size() != 5) {
//						try {
//							lock.wait();
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
						
						try {
							countDownLatch.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
//				}
				
				System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
				throw new RuntimeException();
			}
		},"t2");
		
		t1.start();
		t2.start();
	}
	
	
}
