package cn.tyrone.java.datastructure.stack;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    private LinkedStack<String> linkedStack;

    @BeforeEach
    void init(){

        if (linkedStack == null) {
            this.linkedStack = new LinkedStack<>();
        }

        for (int i = 0; i < 5; i++) {
            String random = RandomStringUtils.randomNumeric(2);
            System.out.println("元素" + i + ":" + random);
            this.linkedStack.push(random);
        }
        System.out.println("-------------------------------------");

    }


    @Test
    void push() {

    }

    @Test
    void pop() {

        String pop = this.linkedStack.pop();
        System.out.println(pop);

    }

    @Test
    void peek() {
        String peek = this.linkedStack.peek();
        System.out.println(peek);
        System.out.println(this.linkedStack.size());
    }

    @Test
    void size() {
        System.out.println(this.linkedStack.size());
    }

    @Test
    void isEmpty() {
        System.out.println(this.linkedStack.isEmpty());
    }

    @Test
    void nextOrder() {
        this.linkedStack.nextOrder();
    }
}