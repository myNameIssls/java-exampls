package cn.tyrone.java.datastructure.queue;

import cn.tyrone.java.datastructure.stack.LinkedStack;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceLoopQueueTest {

    private SequenceLoopQueue<String> sequenceLoopQueue;

    @BeforeEach
    void init(){

        if (sequenceLoopQueue == null) {
            this.sequenceLoopQueue = new SequenceLoopQueue<>();
        }

        for (int i = 0; i < 5; i++) {
            String random = RandomStringUtils.randomNumeric(2);
            this.sequenceLoopQueue.enqueue(random);
        }

    }


    @Test
    void enqueue() {
    }

    @Test
    void dequeue() {

        this.sequenceLoopQueue.nextOrder();
        for (int i = 0; i < 2; i++) {
            String dequeue = this.sequenceLoopQueue.dequeue();
            System.out.println("出队元素：" + dequeue);
        }
        System.out.println("---------------------------");
        this.sequenceLoopQueue.nextOrder();

    }

    @Test
    void getHead() {
        this.sequenceLoopQueue.nextOrder();
        String head = this.sequenceLoopQueue.getHead();
        System.out.println("队首元素：" + head);
    }

    @Test
    void size() {
        this.sequenceLoopQueue.nextOrder();
        System.out.println("元素个数:" + this.sequenceLoopQueue.size());
    }

    @Test
    void isEmpty() {

        boolean empty = this.sequenceLoopQueue.isEmpty();
        System.out.println(empty);

    }

    @Test
    void nextOrder() {
        this.sequenceLoopQueue.nextOrder();
    }

    @Test
    void clear() {
        int size = this.sequenceLoopQueue.size();
        System.out.println("销毁前元素个数：" + size);
        this.sequenceLoopQueue.clear();
        size = this.sequenceLoopQueue.size();
        System.out.println("销毁后元素个数：" + size);
    }
}