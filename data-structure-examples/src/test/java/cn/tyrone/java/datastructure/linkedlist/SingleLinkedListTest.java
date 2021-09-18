package cn.tyrone.java.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

class SingleLinkedListTest {

    @Test
    void add() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(1).add(2).add(3).add(4).add(5);
//        list.append(2);
//        list.append(3);
//        list.append(4);
//        list.append(5);

//        int size = list.size();
//        System.out.println("当前链表存在" + size + "个节点");

//        list.print();

    }

    /**
     * 从数组初始化单链表
     */
    @Test
    void initFromArrays(){
        Object[] array = new Object[]{"a", 1, "b", 2, "c", 3};
        SingleLinkedList<Object> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.initFromArrays(array);
        System.out.println(singleLinkedList.toString());
    }

    /**
     * 链表长度单元测试
     */
    @Test
    void size(){
        Object[] array = new Object[]{"a", 1, "b", 2, "c", 3};
        SingleLinkedList<Object> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.initFromArrays(array);
        int size = singleLinkedList.size();
        System.out.println("链表长度:" + size);
    }

    /**
     * 链表中奇数位与偶数交易位置-单元测试
     */
    @Test
    void oddEvenSwap(){
        Object[] array = new Object[]{"a", 1, "b", 2, "c", 3};
        SingleLinkedList<Object> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.initFromArrays(array);
        System.out.println("位置交换前:" + singleLinkedList.toString());
        singleLinkedList.oddEvenSwap();
        System.out.println("位置交换后:" + singleLinkedList.toString());
    }

    /**
     * 获取数据单元测试
     */
    @Test
    void getData(){
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        SingleLinkedList append = list.add(1).add(2);
//        Object data = append.getData();
//        System.out.println(data);
    }

}