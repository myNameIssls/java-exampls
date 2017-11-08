package cn.tyrone.javase.concurrent;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 声明一个线程对象
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Task task = new Task(); // Callable对象
        Object obj = null; // 用于接收callable接口call方法的返回值

        /**
         * Callable + Future 实现获取线程任务的返回值
         */
        Future future = executorService.submit(task);
        try {
            obj = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Callable + Future 实现获取线程任务的返回值;" + obj);

        /**
         * 通过FutureTask获取线程任务的返回值
         */
        FutureTask futureTask = new FutureTask(task);
        executorService.submit(futureTask);
        obj = futureTask.get();
        System.out.println("通过FutureTask获取线程任务的返回值: " + obj);

        // 关闭线程池
        executorService.shutdown();

    }

    /**
     * 新建Task类并实现Callable接口，重写call()方法。
     */
    static class Task implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("进入子线程。。。。。。。。");
            /**
             * 简单的计算，将计算结果返回
             */
            int count = 0;
            int length = new Random().nextInt(10);
            System.out.println("共循环" + length + "次");
            for (int i = 0 ; i < length ; i ++) {
                count += i;
                System.out.println("count第" + (i + 1) + "次运算的值：" + count);
            }
            return count;
        }
    }

}
