package cn.tyrone.javase.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
	public static void main(String[] args) {
		BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<Object>();
		
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		
		Thread tp = new Thread(producer);
		Thread tc = new Thread(consumer);
		
		tp.start();
		tc.start();
		
	}
}
