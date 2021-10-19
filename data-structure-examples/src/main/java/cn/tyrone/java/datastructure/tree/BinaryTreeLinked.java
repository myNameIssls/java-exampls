package cn.tyrone.java.datastructure.tree;

/**
 * 二叉树二叉链式存储结构
 */
public class BinaryTreeLinked<E> {

    private Node<E> node;

    public Node<E> getNode() {
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
    public BinaryTreeLinked(E data){
        this.node = new Node<>(data);
    }

    /**
     * 添加节点至指定节点
     * @param data
     * @param parent
     * @param nodeLocation
     * @return
     */
    public boolean insertChild(E data, Node<E> parent, NodeLocation nodeLocation) {

        if (parent == null) {
            throw new RuntimeException("父节点不允许为空");
        }

        Node<E> newNode = new Node<>(data);

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
    public boolean deleteChild(Node<E> parent, NodeLocation nodeLocation){

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
    public void preOrder(Node<E> node) {

        System.out.println(node.data);
        Node<E> left = node.left;
        if (left != null) {
            preOrder(left);
        }
        Node<E> right = node.right;
        if (right != null) {
            preOrder(right);
        }

    }

    /**
     * 中序遍历
     * 左节点--根节点--右节点
     * @param node
     */
    public void midOrder(Node<E> node){

        Node<E> left = node.left;
        if (left != null) {
            midOrder(left);
        }

        System.out.println(node.data);

        Node<E> right = node.right;
        if (right != null) {
            midOrder(right);
        }

    }

    /**
     * 后序遍历
     * 左结点 -- 右结点 -- 根结点
     * @param node
     */
    public void afterOrder(Node<E> node){

        Node<E> left = node.left;
        if (left != null) {
            afterOrder(left);
        }

        Node<E> right = node.right;
        if (right != null) {
            afterOrder(right);
        }

        System.out.println(node.data);

    }

    /**
     * 层级遍历
     */
    public Node<E>[] levelOrder(){

        Node<E> node = this.node;

        int count = count(node);

        if (count == 0) {
            return null;
        }

        // 节点队列
        Node<E>[] nodeQueue = new Node[count];

        // 队首指针
        int front = -1;
        // 队尾指针
        int rear = 0;
        nodeQueue[rear] = this.node;

        while (front != rear) {

            front++;
            System.out.println(nodeQueue[front].data);

            Node<E> left = nodeQueue[front].left;
            if (left != null) {
                rear++;
                nodeQueue[rear] = left;
            }

            Node<E> right = nodeQueue[front].right;
            if (right != null) {
                rear++;
                nodeQueue[rear] = right;
            }

        }
        return nodeQueue;
    }



    /**
     * 获取二叉树的高度
     * @return
     */
    public int getHeight(Node<E> node){
        int height = 0;

        if (node == null) {
            return height;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        height = leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;

        return height;
    }

    /**
     * 二叉树节点数量
     * @param node
     * @return
     */
    public int count(Node<E> node){
        int count = 0;

        if (node == null) {
            return count;
        }

        int leftCount = count(node.left);
        int rightCount = count(node.right);

        count = leftCount + rightCount + 1;

        return count;
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
