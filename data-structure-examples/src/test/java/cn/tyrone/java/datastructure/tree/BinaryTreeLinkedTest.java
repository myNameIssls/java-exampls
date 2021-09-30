package cn.tyrone.java.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BinaryTreeLinkedTest {

    private BinaryTreeLinked<String> binaryTreeLinked = null;

    @BeforeEach
    void init(){
        if (binaryTreeLinked == null) {
            binaryTreeLinked = new BinaryTreeLinked<>("A");
            BinaryTreeLinked<String>.Node<String> node = binaryTreeLinked.getNode();
            binaryTreeLinked.insertChild("B", node, BinaryTreeLinked.NodeLocation.LEFT);
            binaryTreeLinked.insertChild("C", node, BinaryTreeLinked.NodeLocation.RIGHT);

            BinaryTreeLinked<String>.Node<String> bNode = node.getLeft();
            binaryTreeLinked.insertChild("D", bNode, BinaryTreeLinked.NodeLocation.LEFT);
            binaryTreeLinked.insertChild("E", bNode, BinaryTreeLinked.NodeLocation.RIGHT);
            BinaryTreeLinked<String>.Node<String> cNode = node.getRight();
            binaryTreeLinked.insertChild("F", cNode, BinaryTreeLinked.NodeLocation.LEFT);
            binaryTreeLinked.insertChild("G", cNode, BinaryTreeLinked.NodeLocation.RIGHT);

            BinaryTreeLinked<String>.Node<String> dNode = bNode.getLeft();
            binaryTreeLinked.insertChild("H", dNode, BinaryTreeLinked.NodeLocation.LEFT);
//            binaryTreeLinked.insertChild("I", cNode, BinaryTreeLinked.NodeLocation.RIGHT);

        }
    }

    @Test
    void insertChild() {

        BinaryTreeLinked<String> binaryTreeLinked = new BinaryTreeLinked<>("A");
        BinaryTreeLinked<String>.Node<String> node = binaryTreeLinked.getNode();
        binaryTreeLinked.insertChild("B", node, BinaryTreeLinked.NodeLocation.LEFT);
        binaryTreeLinked.insertChild("C", node, BinaryTreeLinked.NodeLocation.RIGHT);
        BinaryTreeLinked<String>.Node<String> bNode = node.getLeft();

        binaryTreeLinked.insertChild("D", bNode, BinaryTreeLinked.NodeLocation.LEFT);
        binaryTreeLinked.insertChild("H", bNode, BinaryTreeLinked.NodeLocation.RIGHT);
        System.out.println("----------");
    }

    @Test
    void deleteChild() {
    }

    @Test
    void preorder() {

        BinaryTreeLinked<String>.Node<String> node = binaryTreeLinked.getNode();
        binaryTreeLinked.preOrder(node);
        System.out.println("---------");
    }

    @Test
    void midOrder() {

        BinaryTreeLinked<String>.Node<String> node = binaryTreeLinked.getNode();

        binaryTreeLinked.midOrder(node);
        System.out.println("---------");
    }

    @Test
    void afterOrder() {

        BinaryTreeLinked<String>.Node<String> node = binaryTreeLinked.getNode();

        binaryTreeLinked.afterOrder(node);
        System.out.println("---------");
    }

    /**
     * 层次遍历
     */
    @Test
    void levelOrder(){
        BinaryTreeLinked<String>.Node<String>[] nodes = binaryTreeLinked.levelOrder();
        System.out.println("-----------------");
        Arrays.stream(nodes).forEach(stringNode -> {
            System.out.println(stringNode.getData());
        });
    }

    /**
     * 获取二叉树的高度-单元测试
     */
    @Test
    void getHeight() {

        int height = binaryTreeLinked.getHeight(binaryTreeLinked.getNode());
        System.out.println("二叉树的高度:" + height);
    }

    /**
     * 二叉树节点数量-单元测试
     */
    @Test
    void count(){
        int count = binaryTreeLinked.count(binaryTreeLinked.getNode());
        System.out.println("二叉树的节点数量:" + count);
    }



}