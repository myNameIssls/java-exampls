package cn.tyrone.java.datastructure.queue;

import cn.tyrone.java.datastructure.stack.SequenceStack;

/**
 * 顺序链
 */
public class SequenceLoopQueue<T> {

    private final int MAX_SIZE = 2;
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
    public SequenceLoopQueue(){
        this.front = 0;
        this.rear = 0;
        this.queueArray = (T[]) new Object[MAX_SIZE];
    }

    /**
     * 入队
     * @param obj
     */
    public void enqueue(T obj){
        // (rear + 1) % queueArray.length == front 判断队满的条件
        if ((rear + 1) % queueArray.length == front) {

            // 如果队满，则声明原队列的2倍容量扩容
            T[] p = (T[]) new Object[queueArray.length * 2];

            // 将队列中元素迁移至临时数组中
            if (rear == (queueArray.length - 1)) {
                for (int i = 1; i <= rear; i++) {
                    p[i] = queueArray[i];
                }
            }

            // 将临时数组赋值给原始队列数组
            queueArray = p;

        }

        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = obj;

    }

    /**
     * 删除队列队头元素
     * @return
     */
    public T dequeue(){

        if (isEmpty()) {
            throw new RuntimeException("当前队列是空队列，无法进行出队操作");
        }

        front = (front + 1) % queueArray.length;
        T t = queueArray[front];
        return t;
    }

    /**
     * 获取头元素
     * @return
     */
    public T getHead(){

        if (isEmpty()) {
            throw new RuntimeException("当前队列是空队列，无法进行出队操作");
        }
        T t = queueArray[(front + 1) % queueArray.length];
        return t;
    }

    /**
     * 计算队列中元素个数
     * @return
     */
    public int size(){

        int size = (rear - front + queueArray.length) % queueArray.length;

        return size;
    }

    /**
     * 判断是否为空队列
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 依次访问队列中每一个元素
     */
    public void nextOrder(){
        int i, j = front;

        for (i = 1; i <= size(); i++) {
            j = (j + 1) % queueArray.length;
            System.out.println("元素索引[" + j + "]:" + queueArray[j]);
        }
        System.out.println("---------------------------");

    }

    /**
     * 销毁一个已存在的队列
     */
    public void clear(){
        front = rear = 0;
    }

}
