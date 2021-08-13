package cn.tyrone.java.datastructure.stack;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 顺序栈单元测试
 */
class SequenceStackTest {

    private SequenceStack<String> sequenceStack;

    @BeforeEach
    void init(){

        if (sequenceStack == null) {
            this.sequenceStack = new SequenceStack<>();
        }

        for (int i = 0; i < 5; i++) {
            String random = RandomStringUtils.randomNumeric(2);
            System.out.println("元素" + i + ":" + random);
            this.sequenceStack.push(random);
        }
        System.out.println("-------------------------------------");

    }

    @Test
    void push() {
        if (this.sequenceStack.isEmpty()) {
            this.sequenceStack.push("12313");
        }
    }

    @Test
    void pop() {
        String pop = this.sequenceStack.pop();
        System.out.println("栈顶元素：" + pop);

        System.out.println("删除栈顶元素后输出");

        this.sequenceStack.nextOrder();

    }

    @Test
    void getHead() {

        String head = this.sequenceStack.getHead();
        System.out.println("栈顶元素：" + head);

    }

    @Test
    void isEmpty() {
        boolean empty = this.sequenceStack.isEmpty();

        System.out.println(empty);
    }

    @Test
    void size() {
        int size = this.sequenceStack.size();
        System.out.println("this.sequenceStack共有" + size + "个元素");
    }

    @Test
    void nextOrder() {

        this.sequenceStack.nextOrder();

    }

    @Test
    void clear() {

        this.sequenceStack.clear();

        boolean empty = this.sequenceStack.isEmpty();
        System.out.println(empty);

    }
}