package cn.tyrone.javase.multithreading;

/**
 * 静态内部类单例模式 
 * 解决多线程情况下单例模式
 */
public class InnerSingleton {
	
	private static class Singletion {
		private static Singletion singletion = new Singletion(); 
	}
	
	public static Singletion getInstance(){
		return Singletion.singletion;
	}
	
}
