package cn.tyrone.java.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}