package cn.tyrone.javase.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者
 * @author shanglishuai
 *
 */
public class Producer implements Runnable {
	
	private BlockingQueue<Object> blockingQueue;
	
	// 设置阻塞队列大小
	private final int QUEUE_SIZE = 10;
	
	public Producer(BlockingQueue<Object> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	int task = 1;
	
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("生产者生产数据：" + task);
				blockingQueue.put(task);
				++task;
				// 模拟业务场景
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
