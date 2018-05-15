package cn.tyrone.javase.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 * @author shanglishuai
 *
 */
public class Producer implements Runnable {
	
	private BlockingQueue<Object> blockingQueue;
	
	public Producer(BlockingQueue<Object> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	int i = 0;
	
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("生产者生产数据：" + i);
				blockingQueue.put(i);
				i ++;
				// 休眠1秒钟，模拟业务场景
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
