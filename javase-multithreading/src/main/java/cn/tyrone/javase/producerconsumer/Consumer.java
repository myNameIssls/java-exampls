package cn.tyrone.javase.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * @author shanglishuai
 *
 */
public class Consumer implements Runnable {
	
	private BlockingQueue<Object> blockingQueue;
	
	public Consumer(BlockingQueue<Object> blockintQueue) {
		this.blockingQueue = blockintQueue;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("消费者消费数据: " + blockingQueue.take());
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
