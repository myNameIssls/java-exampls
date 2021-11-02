package cn.tyrone.java.datastructure.tree;

/**
 * 线索二叉树
 * @param <E>
 */
public class BinaryTreeClue<E> {

    private Node<E> node;

    /**
     * 前驱节点
     */
    private Node<E> pre;

    /**
     * 中序线索二叉树
     * 左节点--根节点--右节点
     * @param node
     */
    public void midOrder(Node node){

        if (node == null) {
            return;
        }

        // 处理左子树
        Node left = node.left;
        if (left != null) {
            midOrder(left);
        }
        // 处理前驱结点
        if (left == null) {
            left = this.pre;
            left.leftTag = true;
        }

        // 处理后继结点
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightTag = true;
        }

        // 处理右子树
        Node right = node.right;
        if (right != null) {
            midOrder(right);
        }

    }

    class Node<E> {

        private E data;

        private Node<E> left;

        private Node<E> right;

        /**
         * 是否有前驱结点
         * true:有前驱结点
         * false:有左子树，没有前驱结点
         */
        private boolean leftTag;

        /**
         * 是否有后继结点
         * true:有后继结点
         * false:有右子树，没有后继结点
         */
        private boolean rightTag;

        Node(E data){
            this.data = data;
        }

    }

}
