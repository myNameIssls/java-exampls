package cn.tyrone.java.datastructure.queue;

import cn.tyrone.java.datastructure.stack.SequenceStack;

/**
 * 顺序链
 */
public class SequenceQueue<T> {

    private final int MAX_SIZE = 10;
    private T[] queueArray;
    /**
     * 队头打针
     */
    private int front;

    /**
     * 队尾指针
     */
    private int rear;

    /**
     * 初始化队列
     */
    public SequenceQueue(){
        this.front = 0;
        this.rear = 0;
        this.queueArray = (T[]) new Object[MAX_SIZE];
    }

//    public void

}
