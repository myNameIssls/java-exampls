package cn.tyrone.javase.multithreading;

public class SynchronizedDemo {
	
	private static int balance = 1000;
	
	public static void main(String[] args) {
		System.out.println("账户余额:" + balance);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		}, "addBalance-thread");
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		}, "reduceBalance-thread");
		
		
		
	}
	
	
}
