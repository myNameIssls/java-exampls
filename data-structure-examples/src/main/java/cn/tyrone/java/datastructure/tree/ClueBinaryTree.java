package cn.tyrone.java.datastructure.tree;

/**
 * 线索二叉树
 * @param <E>
 */
public class ClueBinaryTree<E> {

    private Node<E> node;

    class Node<E> {

        private E data;

        private Node<E> leftNode;

        private Node<E> rightNode;

        private boolean leftTag;

        private boolean rightTag;

        Node(E data){
            this.data = data;
        }

    }

}
