package cn.tyrone.javase.interviewcase;

import java.util.ArrayList;
import java.util.List;

public class ThreadWaitNotify {
	private volatile List list = new ArrayList();
	
	public void add(){
		list.add("tyrone");
	}
	
	public int size(){
		return list.size();
	}
	
	public static void main(String[] args) {
		final ThreadWaitNotify twn = new ThreadWaitNotify();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					twn.add();
					System.out.println("当前线程: " + Thread.currentThread().getName() + "添加了一个元素！");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					if (twn.size() == 5) {
						System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
						throw new RuntimeException();
					}
				}
			}
		},"t2");
		
		t1.start();
		t2.start();
	}
	
	
}
