package cn.tyrone.java.datastructure.tree;

/**
 * 二叉树二叉链式存储结构
 */
public class BinaryTreeLinked<T> {

    private Node<T> node;

    public Node<T> getNode() {
        return node;
    }

    /**
     * 创建空二叉树
     */
    public BinaryTreeLinked(){
        this.node = new Node<>();
    }

    /**
     * 创建以数据data为根节点的二叉树
     * @param data
     */
    public BinaryTreeLinked(T data){
        this.node = new Node<>(data);
    }

    /**
     * 添加节点至指定节点
     * @param data
     * @param parent
     * @param nodeLocation
     * @return
     */
    public boolean insertChild(T data, Node<T> parent, NodeLocation nodeLocation) {

        if (parent == null) {
            throw new RuntimeException("父节点不允许为空");
        }

        Node<T> newNode = new Node<>(data);

        if (nodeLocation.equals(NodeLocation.LEFT)) {
            Node left = parent.left;
            if (left == null) {
                parent.left = newNode;
            }

            if (left != null) {
                newNode.left = parent.left;
                parent.left = newNode;
            }
        }

        if (nodeLocation.equals(NodeLocation.RIGHT)) {
            Node right = parent.right;
            if (right == null) {
                parent.right = newNode;
            }

            if (right != null) {
                newNode.right = parent.right;
                parent.right = newNode;
            }
        }

        return true;
    }

    /**
     * 删除子节点
     * @return
     */
    public boolean deleteChild(Node<T> parent, NodeLocation nodeLocation){

        if (parent == null) {
            throw new RuntimeException("父节点不允许为空");
        }

        if (nodeLocation.equals(NodeLocation.LEFT)) {
            parent.left = null;
        }

        if (nodeLocation.equals(NodeLocation.RIGHT)) {
            parent.right = null;
        }

        return true;
    }

    /**
     * 先序遍历
     * 根节点--左节点--右节点
     */
    public void preOrder(Node<T> node) {

        System.out.println(node.data);
        Node<T> left = node.left;
        if (left != null) {
            preOrder(left);
        }
        Node<T> right = node.right;
        if (right != null) {
            preOrder(right);
        }

    }

    /**
     * 中序遍历
     * 左节点--根节点--右节点
     * @param node
     */
    public void midOrder(Node<T> node){

        Node<T> left = node.left;
        if (left != null) {
            midOrder(left);
        }

        System.out.println(node.data);

        Node<T> right = node.right;
        if (right != null) {
            midOrder(right);
        }

    }

    /**
     * 后序遍历
     * @param node
     */
    public void afterOrder(Node<T> node){

        Node<T> left = node.left;
        if (left != null) {
            afterOrder(left);
        }

        Node<T> right = node.right;
        if (right != null) {
            afterOrder(right);
        }

        System.out.println(node.data);

    }

    /**
     * 二叉树节点
     * @param <T>
     */
    public class Node<T> {

        private T data;

        private Node<T> left;

        private Node<T> right;

        public Node(){
            this.data = null;
            this.left = null;
            this.right = null;
        }

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

    }

    /**
     * 节点位置
     */
    enum NodeLocation {
        LEFT,
        RIGHT
    }


}
