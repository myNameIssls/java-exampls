package cn.tyrone.javase.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static void main(String[] args) {

        /**
         * 设置CountDownLatch的初始计数值为2，
         * 表明需要调用两次countDown()方法来唤醒被await()方法阻塞的线程
         */
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("进入线程1，等待其它线程处理完成。。。。。。");
                try {
                    /**
                     * 通知主线程阻塞，需要等待同一组操作中的其它线程执行完毕，
                     * 并调用countDown()方法对CountDownLatch的初始计数值进行修改，
                     * 直到初始计数值等于0的时候才开始继续执行
                     */
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("其它线程处理完毕，t1线程继续执行");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2线程开始初始化动作");
                try {
                    // 休眠3秒钟，模拟线程处理业务的过程
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2线程执行完成");

                // 调用countDown()方法通知被await()方法阴塞的线程
                /**
                 * countDown()方法每调用一次，CountDownLatch的初始计数值就会减少1，
                 * 当初始计数值等于0的时候，被await()阴塞的线程便可以继续执行了
                 */
                countDownLatch.countDown();
                /**
                 * 由于CountDownLatch的初始计数值等于2，所以countDown()需要调用两次来唤醒被苍茫await()方法阻塞的线程
                 */
                countDownLatch.countDown();
            }
        });

        // 启动线程
        t1.start();
        t2.start();

    }
}
