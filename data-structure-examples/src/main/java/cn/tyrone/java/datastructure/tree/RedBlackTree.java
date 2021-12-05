package cn.tyrone.java.datastructure.tree;

public class RedBlackTree<K extends Comparable, V> {

    private static final boolean RED = true;
    private static final boolean BLECK = false;

    /**
     * 根结点
     */
    private Node root;

    /**
     * 是否是红色结点
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        return node.color == RED;
    }

    /**
     * 是否是黑色结点
     * @param node
     * @return
     */
    private boolean isBleck(Node node) {
        return node.color == BLECK;
    }

    /**
     * 设置结点颜色为红色
     * @param node
     */
    private void setRed(Node node) {
        node.color = RED;
    }
    /**
     * 设置结点颜色为黑色
     * @param node
     */
    private void setBlack(Node node) {
        node.color = BLECK;
    }

    /**
     * 左旋
     * @param node 旋转结点
     */
    private void leftRotate(Node node) {

        // 旋转结点的父结点
        Node parent = node.parent;
        // 旋转结点的右子树结点
        Node right = node.right;

        if (parent == null) {
            right.parent = null;
            this.root = right;
        } else {
            // 旋转结点的祖父结点
            Node gParent = parent.parent;
            // 设置插入结点的父结点是祖父结点
            node.parent = gParent;
            if (parent.left == node) {
                parent.left = right;
            }
            if (parent.right == node) {
                parent.right = right;
            }
        }

        // 旋转结点的右子树结点的左子树结点
        Node left = right.left;
        // 设置旋转结点的右子树结点是旋转结点的右子树结点的左子树结点
        node.right = left;
        // 设置旋转结点的父结点是旋转结点的右子树结点
        node.parent = right;
        // 设置旋转结点的右子树结点左子树结点是当前旋转结点
        right.left = node;

    }

    /**
     * 右旋
     * @param node 旋转结点
     */
    private void rightRotate(Node node) {

        // 旋转结点的父结点
        Node parent = node.parent;

        // 旋转结点的左子树结点
        Node left = node.left;

        if (parent == null) {
            left.parent = null;
            this.root = left;
        } else {
            // 旋转结点的祖父结点
            Node gParent = parent.parent;
            // 设置插入结点的父结点是祖父结点
            node.parent = gParent;
            if (parent.left == node) {
                parent.left = left;
            }
            if (parent.right == node) {
                parent.right = left;
            }
        }

        // 旋转结点的左子树结点的右子树结点
        Node right = left.right;
        // 设置旋转结点的左子树结点等于旋转结点的左子树结点的右子树结点
        node.left = right;
        // 设置旋转结点的父结点是旋转结点的左子树结点
        node.parent = left;
        // 设置旋转结点的左子树结点右子树结点是当前旋转结点
        left.right = node;

    }

    /**
     * 插入
     * @param key
     * @param value
     */
    public void insert(K key, V value) {

        // 初始化新插入的结点
        Node newNode = new Node(key, value, RED,null, null, null);

        // 当前根结点为空结点
        if (this.root == null) {
            this.root = newNode;
            this.root.color = BLECK;
            return;
        }

        Node parentNode = null;
        Node rootNode = this.root;
        // 寻找父结点过程
        while (rootNode != null) {
            parentNode = rootNode;

            int compare = newNode.key.compareTo(parentNode.key);

            // compare > 0, newNode的key值 > 当前parentNode的key值
            if (compare > 0) {
                rootNode = parentNode.right;
            }
            // compare == 0, newNode的key值 = 当前parentNode的key值
            if (compare == 0) {
                rootNode.value = value;
                return;
            }
            // compare < 0, newNode的key值 < 当前parentNode的key值
            if (compare < 0) {
                rootNode = parentNode.left;
            }
        }

        // 设置新插入结点的父结点
        newNode.parent = parentNode;

        int compare = newNode.key.compareTo(parentNode.key);
        if (compare > 0) {
            parentNode.right = newNode;
        }
        if (compare < 0) {
            parentNode.left = newNode;
        }

        // 修复红黑树
        this.insertFixup(newNode);

    }

    /**
     * 修复红黑树不平衡方法
     * @param node 新插入的结点
     */
    private void insertFixup(Node node){
        // 设置根结点颜色为黑色
        this.root.color = BLECK;
        // 父结点
        Node parentNode = node.parent;

        // 当前插入结点的父结点为红色结点
        if (parentNode != null && isRed(parentNode)) {

            // 祖父结点
            Node gParentNode = parentNode.parent;
            // 叔叔结点
            Node uncleNode = parentNode == gParentNode.left ? gParentNode.right : gParentNode.left;

            // 叔叔结点不为空，且叔叔结点为红色
            if (uncleNode != null && isRed(uncleNode)) {
                // 设置父结点和叔叔结点为黑色结点。
                setBlack(parentNode);
                setBlack(uncleNode);
                // 设置祖父结点为红色结点
                setRed(gParentNode);
                // 设置祖父结点为当前插入结点，递归变色
                insertFixup(gParentNode);
                return;
            }

            // 叔叔结点不为空且颜色为黑色或者叔叔结点为空结点
            if ((uncleNode != null && isBleck(uncleNode)) || uncleNode == null) {

                // 父结点属于祖父结点的左子树结点
                if (parentNode == gParentNode.left) {
                    // 当前插入结点位于父结点左子树结点
                    if (node == parentNode.left) {
                        // 设置插入结点的父结点为黑色结点
                        setBlack(parentNode);
                        // 设置插入结点的祖父结点为红色结点
                        setRed(gParentNode);
                        // 基于祖父结点进行右旋操作
                        rightRotate(gParentNode);
                    }

                    // 当前插入结点位于父结点左子树结点
                    if (node == parentNode.right) {
                        // 基于当前新插入结点的父结点进行左旋操作
                        leftRotate(parentNode);
                        // 设置插入结点为黑色结点
                        setBlack(node);
                        // 设置插入结点的祖父结点为红色结点
                        setRed(gParentNode);
                        // 基于祖父结点进行右旋操作
                        rightRotate(gParentNode);
                    }

                }
                // 父结点属于祖父结点的右子树结点
                if (parentNode == gParentNode.right) {
                    // 当前插入结点位于父结点右子树结点
                    if (node == parentNode.right) {
                        // 设置插入结点的父结点为黑色结点
                        setBlack(parentNode);
                        // 设置插入结点的祖父结点为红色结点
                        setRed(gParentNode);
                        // 基于祖父结点进行左旋操作
                        leftRotate(gParentNode);
                    }

                    // 当前插入结点位于父结点左子树结点
                    if (node == parentNode.left) {
                        // 基于当前新插入结点的父结点进行右旋操作
                        rightRotate(parentNode);
                        // 设置插入结点为黑色结点
                        setBlack(node);
                        // 设置插入结点的祖父结点为红色结点
                        setRed(gParentNode);
                        // 基于祖父结点进行左旋操作
                        leftRotate(gParentNode);
                    }
                }

            }

        }
    }



    class Node<K extends Comparable, V> {

        private K key;
        private V value;
        private boolean color;
        private Node parent;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(K key, V value, boolean color, Node parent, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

}
