package cn.tyrone.java.datastructure.queue;

import cn.tyrone.java.datastructure.stack.LinkedStack;

/**
 * 链队列
 */
public class LinkedQueue<T> {

    /**
     * 头节点
     */
    private Node<T> front;

    /**
     * 尾节点
     */
    private Node<T> rear;

    private int length;

    /**
     * 构造空链队列
     */
    public LinkedQueue(){
        Node<T> node = new Node<T>(null);
        this.rear = node;
        this.front = node;
        length = 0;
    }

    /**
     * 入队
     * @param obj
     */
    public void enqueue(T obj){

        Node node = new Node(obj);

        this.rear = node;
        this.rear.next = node;
        this.length++;

    }

    /**
     * 出队
     * @return
     */
    public T dequeue(){

        if (this.isEmpty()) {
            return null;
        }

        Node<T> node = front.next;
        T data = node.data;
        Node<T> next = node.next;

        front.next = next;
        length--;

        return data;

    }

    /**
     * 判断是否为空队列
     * @return
     */
    public boolean isEmpty(){
        return front.next == null;
    }

    /**
     * 获取头元素
     * @return
     */
    public T getHead(){

        if (isEmpty()) {
            throw new RuntimeException("当前队列是空队列，无法进行出队操作");
        }
        Node<T> front = this.front;
        T data = front.data;
        return data;
    }

    /**
     * 计算队列中元素个数
     * @return
     */
    public int size(){

        int size = this.length;

        return size;
    }

    /**
     * 循环输出队列元素
     */
    public void nextOrder(){
        Node<T> node = front.next;

        while (node != null) {
            System.out.println("队列元素：" + node.data);
            node = node.next;
        }

    }

    /**
     * 销毁队列
     */
    public void clear(){
        this.front.next = null;
        this.rear.next = null;
    }

    /**
     * 内部类，链队列内部结点
     * @param <T>
     */
    private class Node<T> {

        /**
         * 数据域
         */
        private T data;

        /**
         * 地址域
         */
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

    }

}
