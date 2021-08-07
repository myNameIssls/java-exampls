package cn.tyrone.javase.multithreading.helloword;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
	public static void main(String[] args) {
		
		// 获取 Java 线程管理器 MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		
		// 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		
		// 遍历线程信息，打印线程ID和线程名称
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
		}
		
		
	}
}
