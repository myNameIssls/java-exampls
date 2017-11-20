package cn.tyrone.javase.socket.helloworld;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerExecuterPool {

    private ExecutorService executor;

    public HandlerExecuterPool(int maxPoolSize, int queueSize) {
        this.executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>( queueSize )
        );
    }

    public void execute (Runnable task) {
        this.executor.execute( task );
    }

}
