package cn.tyrone.javase.multithreading;

/**
 * 单例模式，双层校验获取
 * 解决多线程情况下单例模式
 */
public class DubbleSingleton {
	private static DubbleSingleton ds = null;

	public static DubbleSingleton getDs() {
		
		synchronized (DubbleSingleton.class) {
			if (ds == null) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ds = new DubbleSingleton();
			}
		}
//		if (ds == null) {
//			try {
//				// 模仿ds加载过程
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//			}
//
//			synchronized (DubbleSingleton.class) {
//				if (ds == null) {
//					ds = new DubbleSingleton();
//				}
//			}
//
//		}

		return ds;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		}, "t2");

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		}, "t3");
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
