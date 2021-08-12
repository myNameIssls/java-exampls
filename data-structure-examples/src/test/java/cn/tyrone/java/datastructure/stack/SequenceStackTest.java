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

    }

    @Test
    void push() {
        int size = 10;

        for (int i = 0; i < size; i++) {
            String random = RandomStringUtils.randomNumeric(2);
            System.out.println("第" + (i+1) + "个元素:" + random);
            this.sequenceStack.push(random);
        }

        this.sequenceStack.nextOrder();
    }

    @Test
    void pop() {

        this.sequenceStack.push("123");
        this.sequenceStack.push("456");
//        System.out.println("删除之前打印");
//        this.sequenceStack.nextOrder();
        String pop = this.sequenceStack.pop();
        System.out.println(pop);
//        String pop1 = this.sequenceStack.pop();
//        System.out.println(pop1);
        this.sequenceStack.nextOrder();

//        System.out.println("删除之后打印");
//        this.sequenceStack.nextOrder();


    }

    @Test
    void getHead() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void nextOrder() {
    }

    @Test
    void clear() {
    }
}