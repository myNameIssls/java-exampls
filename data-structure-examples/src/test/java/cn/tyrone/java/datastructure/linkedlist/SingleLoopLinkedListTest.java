package cn.tyrone.java.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLoopLinkedListTest {

    @Test
    void add() {

        SingleLoopLinkedList<Integer> loopLinkedList = new SingleLoopLinkedList<>();
        loopLinkedList.add(1);
        loopLinkedList.add(2);
        loopLinkedList.add(3).add(4);
        System.out.println("");
    }
}