package cn.tyrone.javase.multithreading.synchronizeddemo.locktype;

public class ObjThread extends Thread {
	
	
	private LockTestClass lock;
	private int i = 0;
	
	public ObjThread(LockTestClass lock, int i) {
		this.lock = lock;
		this.i = i;
	}
	
	@Override
	public void run() {
		// 无锁方法
//		lock.noSynMethod(this.getId(), this);
		// 对象锁方法1，synchronized 修饰非静态方法
		lock.synOnMethod();
		// 对象锁方法2， synchronized 修饰 this 当前类对象
		lock.synInMethod();
		// 私有锁方法，synchronized 修饰对象
//		lock.synMethodWithObj();
		// 类锁方法，synchronized修饰静态方法
//		LockTestClass.increament();
	}

}
