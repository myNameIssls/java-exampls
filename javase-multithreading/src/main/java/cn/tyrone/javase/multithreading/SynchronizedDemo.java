package cn.tyrone.javase.multithreading;

public class SynchronizedDemo {
	
	public static void main(String[] args) {
		
		Account account = new Account();
		
		System.out.println("账户初始余额:" + account.getBalance());
		
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int balance = account.calc("add", 100);
					System.out.println("当前线程:" + Thread.currentThread().getName() + "\t账户余额-添加操作:" + balance);
				}
			}, "addBalance-thread").start();
			
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int balance = account.calc("reduce", 100);
					System.out.println("当前线程:" + Thread.currentThread().getName() + "\t账户余额-减少操作:" + balance);
				}
			}, "reduceBalance-thread").start();
		}
		
	}
	
	
}
