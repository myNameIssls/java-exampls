package cn.tyrone.java.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

class SingleLinkedListTest {

    @Test
    void append() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.append(1).append(2).append(3).append(4).append(5);
//        list.append(2);
//        list.append(3);
//        list.append(4);
//        list.append(5);

        int size = list.size();
        System.out.println("当前链表存在" + size + "个节点");

        list.print();

    }

    @Test
    void add() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        list.print();

    }
}