package cn.tyrone.java.datastructure.queue;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    private LinkedQueue<String> linkedQueue = null;

    @BeforeEach
    void init(){

        if (this.linkedQueue == null) {
            this.linkedQueue = new LinkedQueue<String>();
        }

        for (int i = 0; i < 5; i++) {
            String random = RandomStringUtils.randomNumeric(2);
            this.linkedQueue.enqueue(random);
        }
    }

    /**
     * 入队单元测试
     */
    @Test
    void enqueue() {

        this.linkedQueue.nextOrder();

    }

    @Test
    void dequeue() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void getHead() {
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