package cn.tyrone.java.datastructure.stack;

import java.util.Arrays;

/**
 *
 * @param <T>
 */
public class SequenceStack<T> {

    final int MAX_SIZE = 5;

    private T[] stackArray;

    // 指针
    private int top;

    public SequenceStack(){
        // top的初始值为-1，指向栈底，而这个top==-1也可作为栈空的标志，
        // 每当插入一个新的栈顶元素时，先把指针top增加1，再把入栈的元素放到top指针指向的位置
        this.top = -1;
        this.stackArray = (T[]) new Object[MAX_SIZE];
    }

    public SequenceStack(int maxSize){

        if (maxSize <= 0) {
            System.out.println("数组长度要大于0,否则退出程序运行");
            System.exit(1);
        }

        this.top = -1;
        this.stackArray = (T[]) new Object[maxSize];
    }

    /**
     * 在栈顶位置插入一个新元素
     * @param obj
     */
    public void push(T obj){

        // 栈满
        if (this.top == this.stackArray.length - 1) {
            T[] p = (T[]) new Object[this.top * 2 + 2];
            for (int i = 0; i <= top; i++) {
                p[i] = this.stackArray[i];
            }
            this.stackArray = p;
        }

        this.top++;
        this.stackArray[top] = obj;
    }

    /**
     * 删除栈顶元素
     * @return
     */
    public T pop(){
        if (this.top == -1) {
            System.out.println("当前数据栈已空，无法删除元素");
            return null;
        }
        this.top--;
        return this.stackArray[this.top + 1];
    }

    /**
     * 获取栈顶数据元素
     * @return
     */
    public T getHead(){
        if (this.top == -1) {
            System.out.println("当前数据栈已空，无法删除元素");
            return null;
        }
        this.top--;
        return this.stackArray[this.top + 1];
    }

    /**
     * 判断当前栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.top == -1;
    }

    /**
     * 获取栈中元素个数
     * @return
     */
    public int size(){
        return this.top + 1;
    }

    /**
     * 依次访问栈中元素并输出
     */
    public void nextOrder(){
//        Arrays.stream(this.stackArray).forEach(t -> System.out.println(t));
        for (int i = this.top; i >= 0; i--) {
            System.out.println(this.stackArray[i]);
        }
    }

    /**
     * 销毁一个已存在的栈
     */
    public void clear(){
        this.top = -1;
    }

    public static void main(String[] args) {
        SequenceStack<String> sequenceStack = new SequenceStack<>();
        boolean empty = sequenceStack.isEmpty();
        System.out.println(empty);
    }

}
