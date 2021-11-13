package cn.tyrone.java.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BalanceBinaryTreeTest {

    private BalanceBinaryTree balanceBinaryTree = null;

    @BeforeEach
    void init(){

//        int[] array = {63, 55, 90, 42, 58, 70, 98, 10, 45, 67, 83};
//        int[] array = {5, 4, 3};
//        int[] array = {5, 3, 4};
//        int[] array = {6, 7, 8};
        int[] array = {6, 8, 7};
        if (balanceBinaryTree == null) {
            balanceBinaryTree = new BalanceBinaryTree();
        }

        Arrays.stream(array).forEach(value -> {
            BalanceBinaryTree.Node node = new BalanceBinaryTree.Node(value);
            balanceBinaryTree.insert(node);
        });

    }

    @Test
    void getBalanceFactor() {
        int balanceFactor = balanceBinaryTree.getBalanceFactor();
        System.out.println("树平衡因子：" + balanceFactor);
    }

    @Test
    void getHeight() {
        int treeHeight = balanceBinaryTree.getHeight();
        System.out.println("树高度：" + treeHeight);
        int height = balanceBinaryTree.getHeight(balanceBinaryTree.getRoot());
        System.out.println("根节点高度：" + height);
    }

    @Test
    void insert() {
    }
}