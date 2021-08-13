package cn.tyrone.java.datastructure.stack;

/**
 * 链栈
 */
public class LinkedStack<T> {

    // 栈顶指针
    private Node<T> top;
    // 存储栈的长度
    private int length;

    public LinkedStack(){
        this.length = 0;
        this.top = null;
    }

    /**
     * 入栈
     * @param obj
     */
    public void push(T obj){
        this.top = new Node<>(obj, this.top);
        length ++;
    }

    /**
     * 出栈, 返回当前栈顶元素
     * @return
     */
    public T pop(){
        if (this.top == null) {
            System.out.println("当前栈为空");
        }

        T temp = this.top.data;
        this.top = top.next;

        length --;
        return temp;

    }

    /**
     * 获取当前栈顶元素，元素未出栈
     * @return
     */
    public T peek() {
        return this.top == null ? null : this.top.data;
    }

    /**
     * 获取栈数据元素个数
     * @return
     */
    public int size(){
        return length;
    }

    /**
     * 判断当前栈是否为空栈
     * @return
     */
    public boolean isEmpty(){
        return this.top == null;
    }

    /**
     * 循环遍历当前栈中元素
     */
    public void nextOrder(){
        Node<T> p = top;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    private class Node<T> {

        /**
         * 数据域
         */
        private T data;

        /**
         * 地址域
         */
        private Node<T> next;

        public Node(){

        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }

}
