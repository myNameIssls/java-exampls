package cn.tyrone.javase.multithreading;

/**
 * 通过实现Runnable创建多线程
 *
 */
public class ThreadRunnable implements Runnable {

	/**
	 * 实现run方法
	 */
	@Override
	public void run() {
		System.out.println("ThreadRunnable:" + Thread.currentThread().getName());
	}

}
