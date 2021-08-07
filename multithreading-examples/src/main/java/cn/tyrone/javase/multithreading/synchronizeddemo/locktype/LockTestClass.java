package cn.tyrone.javase.multithreading.synchronizeddemo.locktype;

public class LockTestClass {
	
	// 用于类锁计数
	private static int i = 0;
	// 私有锁
	private Object object = new Object();
	
	/**
	 * 无锁方法
	 * @param threadID
	 * @param thread
	 */
	public void noSynMethod(long threadID, ObjThread thread) {
		System.out.println("nosyn: class obj is:\t" + thread + "\t threadId:\t" + threadID);
	}
	
	/**
	 * 对象锁方法1
	 * synchronized 修饰非静态方法
	 */
	synchronized public void synOnMethod() {
		System.out.println("对象锁方法1:\t synchronized public void method:" + "\t\t当前时间毫秒数:\t" + System.currentTimeMillis() + "ms");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("对象锁方法1:\t synchronized public void method 结束");
	}
	
	/**
	 * 对象锁方法2
	 * synchronized 修饰 this 当前类对象
	 */
	public void synInMethod() {
		synchronized(this) {
			System.out.println("对象锁方法2:\t synchronized(this):" + "\t\t当前时间毫秒数:\t" + System.currentTimeMillis() + "ms");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("对象锁方法2:\t synchronized(this)结束");
		}
	}
	
	/**
	 * 私有锁
	 * synchronized(obj) 修饰对象
	 */
	public void synMethodWithObj() {
		synchronized(object) {
			System.out.println("私有锁:\t synchronized(obj):" + "\t\t当前时间毫秒数:\t" + System.currentTimeMillis() + "ms");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("私有锁:\t synchronized(obj)结束");
		}
	}
	
	/**
	 * 类锁
	 */
	synchronized public static void increament() {
		System.out.println("类锁: i = " + i + "\t\t当前时间毫秒数:\t" + System.currentTimeMillis() + "ms");
		i++;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("类锁结束");
	}
	
	
}
