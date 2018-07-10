package cn.tyrone.javase.interviewcase;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CrossBrigeDemo {

	// 计时器，表示过桥的用时
	private int totalTime = 0;

	/**
	 * 过桥
	 * 
	 * @param priorityQueue
	 */
	public void crossBrige(PriorityQueue<Integer> priorityQueue) {

		int index = 0; // 表示第几次过桥
		int lastIndex = priorityQueue.size() - 1; // 表示最后一次过桥
		int first = priorityQueue.peek(); // 获取队列中第一个元素
		while (priorityQueue.peek() != null) {

			if (index == 0) {
				priorityQueue.remove();
				index++;
				continue;
			}
			index++;
			// 移除并获取队列中头元素
			int node = priorityQueue.remove();

			count(first, node, index, lastIndex);

		}

	}

	/**
	 * 计时
	 * 
	 * @param first
	 * @param node
	 * @param index
	 * @param lastIndex
	 */
	public void count(int first, int node, int index, int lastIndex) {

		// 如果最后一次过桥，不需要再记录返回的时间
		int crossBrigeTime = index == lastIndex ? node : first + node;
		totalTime += crossBrigeTime;

	}

	public static void main(String[] args) {

		// 用于存储每个人过桥的用时，可以是无序的
		List<Integer> mins = Arrays.asList(2, 5, 10, 1);
		// 用优先级队列来存储每个人的过桥用时，并按优先级排序
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		priorityQueue.addAll(mins);

		CrossBrigeDemo t = new CrossBrigeDemo();

		t.crossBrige(priorityQueue);

		System.out.println(t.totalTime);

	}

}
