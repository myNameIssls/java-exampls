package cn.tyrone.javase.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
	
	/**
	 * 用于输出队列
	 * @param queue
	 */
	private static void printQ(Queue queue) {
		while (queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
	}
	
	public static void main(String[] args) {
		
		Queue<Character> queue = new LinkedList<Character>();
		     
		String str = "QueueCharacter";
		
		for (char c : str.toCharArray()) {
			queue.offer(c); // 向队列添加元素
		}
		
		// 输出队列元素
//		printQ(queue);
		
		// 不移除元素的情况下，返回队头
		System.out.println(queue.peek());
		
		// 移除并返回队头,同时打印队列
		System.out.println(queue.poll());
		
		printQ(queue);
		
	}

	
}
