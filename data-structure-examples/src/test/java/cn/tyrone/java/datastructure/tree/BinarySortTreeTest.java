package cn.tyrone.java.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySortTreeTest {

    private BinarySortTree binarySortTree = null;

    @BeforeEach
    void init(){
        int[] array = {63, 55, 90, 42, 58, 70, 98, 10, 45, 67, 83};
        if (binarySortTree == null) {
            binarySortTree = new BinarySortTree();
        }

        binarySortTree.initfromArrays(array);

    }

    @Test
    void insert() {
    }

    @Test
    void midOrder(){
        binarySortTree.midOrder(binarySortTree.getRoot());
    }

    @Test
    void search() {
        int value = 10;
        BinarySortTree.Node node = binarySortTree.search(value);
        System.out.println(node.getData());
    }

    @Test
    void searchParent() {
        int value = 11;
        BinarySortTree.Node node = binarySortTree.searchParent(value);
        if (node != null) {
            System.out.println(node.getData());
        } else {
            System.out.println("无父节点");
        }

    }

}