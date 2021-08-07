package cn.tyrone.javase.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    static class Runner implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private String name;

        public Runner (CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * (new Random()).nextInt(5));

                System.out.println(name + "-准备ok！");

                /**
                 * 阻塞当前线程，直到被阻塞线程的数量等于CyclicBarrier对象的初始计数值时开始继续执行后续的程序
                 */
                cyclicBarrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(name + " Let's go!!!");

        }
    }

    public static void main(String[] args) {

        /**
         * 初始化一个栅栏数为3的CyclicBarrier对象
         * 意味着当前有3个任务需要同时完成后再进入一下任务
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        /**
         * 初始化一个数量为3的线程池，并分别实例化三个线程
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(new Runner(cyclicBarrier, "zhangsan")));
        executorService.submit(new Thread(new Runner(cyclicBarrier, "lisi")));
        executorService.submit(new Thread(new Runner(cyclicBarrier, "wangwu")));

        executorService.shutdown();

    }


}
