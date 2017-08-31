package cn.tyrone.javase.multithreading.differentthread;

/**
 * 需求描述：
 * 类级别线程锁：即当不同的类对象在不同的线程下访问同一个方法，
 * 如何做到在a线程访问结束以后，b线程再开始呢？
 * 解决方案：在方法上加synchronized关键字，并将方法置为static
 */
public class MultiThread {
	private static int num = 0;

	public static synchronized void print(String tag) {
		
		if (tag.equals("a")) {
			System.out.println("tag a, set num over!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("tag b, set num over!");
		}
		
		System.out.println("tag " + tag + ",num = " + num);
		
	}
	
	public static void main(String[] args) {
		MultiThread t1 = new MultiThread();
		MultiThread t2 = new MultiThread();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t1.print("a");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t2.print("b");
			}
		}).start();
		
	}
	
	
}
