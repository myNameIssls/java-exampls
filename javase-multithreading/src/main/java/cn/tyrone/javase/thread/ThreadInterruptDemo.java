package cn.tyrone.javase.thread;

public class ThreadInterruptDemo implements Runnable {

    @Override
    public void run() {

//        System.out.println("第一次调用Thread.interrupted()" + Thread.interrupted());
//        System.out.println("第二次调用Thread.interrupted()" + Thread.interrupted());

        /**
         * isInterrupted()
         * 用来测试当前线程的运行状态
         * true：表示当前线程为中断状态
         * false：表示当前线程为运行状态
         * 可以通过这样的方法来中断线程运行
         * 如果这句代码之前使用过Thread.interrpted()方法，则不会中断线程。
         * 因为调用Thread.interrpted()这个方法后，已经把当前线程状态给清除了。
         */
        if (Thread.currentThread().isInterrupted()){
            System.out.println("由于线程状态是中断，所以return不再执行线程任务");
            return;
        }

        while (true) {
            try {
                Thread.sleep(3L);
                System.out.println("线程正在执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadInterruptDemo(), "ThreadInterruptDemo");
        // 开启线程
        thread.start();

        /**
         * 中断当前线程
         * 该方法仅设置当前线程的状态为中断，实际上并不中断线程的运行
         * 如果要中断线程的运行，还需要当前线程自己中断
         */
        thread.interrupt();
    }

}
