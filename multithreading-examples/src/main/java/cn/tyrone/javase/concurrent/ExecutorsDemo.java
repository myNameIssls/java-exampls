package cn.tyrone.javase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池工具类
 */
public class ExecutorsDemo {

    public static void main(String[] args) {

        ExecutorService executor = null;

        // 创建一个单线程线程池
//        executor=Executors.newSingleThreadExecutor();
        // 创建一个缓存线程池
//        executor=Executors.newCachedThreadPool();

        // 创建一个固定线程数量的线程池
        executor=Executors.newFixedThreadPool( 5 );
        for (int i = 0 ; i < 20 ; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("into: " + no);
                        Thread.sleep( 1000L );
                        System.out.println("end: " + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute( runnable );
        }

        executor.shutdown();
        System.out.println("Thread Main End!!!!");

    }


}
