package cn.tyrone.java.datastructure.tree;

import java.util.Arrays;

/**
 * 二叉排序树
 */
public class BinarySortTree {

    private Node root;

    /**
     * 通过数据初始化二叉排序树
     * @param array
     */
    public void initfromArrays(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        Arrays.stream(array).forEach(value -> {
            Node node = new Node(value);
            this.insert(node);
        });


    }

    /**
     * 插入结点
     * @param node
     */
    public void insert(Node node){

        if (node == null) {
            return;
        }

        if (this.root == null) {
            this.root = node;
            return;
        }

        Node root = this.root;

        while (root != null) {

            if (node.data < root.data) {

                Node left = root.left;
                if (left == null) {
                    root.left = node;
                    return;
                }

                root = left;

            }

            if (node.data > root.data) {

                Node right = root.right;
                if (right == null) {
                    root.right = node;
                    return;
                }

                root = right;

            }

        }

    }

    /**
     * 查询结点
     * @param value
     * @return
     */
    public Node search(int value) {

        Node root = this.root;

        while (root != null) {

            if (root.data == value) {
                return root;
            }

            if (value < root.data) {
                Node left = root.left;
                if (left == null) {
                    return null;
                }
                root = left;
            }

            if (value > root.data) {

                Node right = root.right;

                if (right == null) {
                    return null;
                }
                root = right;
            }

        }

        return null;
    }

    /**
     * 查询父结点
     * @param value
     * @return
     */
    public Node searchParent(int value){

        Node root = this.root;

        while (root != null) {

            Node left = root.left;
            Node right = root.right;

            if ((left != null && left.data == value) ||
                    (right != null && right.data == value)) {

                return root;

            } else {

                if (left != null && value < root.data) {
                    root = left;
                    continue;
                }

                if (right != null && value > root.data) {
                    root = right;
                    continue;
                }

                return null;

            }

        }

        return null;
    }

    /**
     * 删除子结点
     * @param value
     */
    public void delete(int value) {

    }

    /**
     * 中序遍历
     * 左节点--根节点--右节点
     * @param node
     */
    public void midOrder(Node node){

        Node left = node.left;
        if (left != null) {
            midOrder(left);
        }

        System.out.println(node.data);

        Node right = node.right;
        if (right != null) {
            midOrder(right);
        }

    }

    class Node {

        private int data;

        private Node left;

        private Node right;

        public Node(){

        }

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
