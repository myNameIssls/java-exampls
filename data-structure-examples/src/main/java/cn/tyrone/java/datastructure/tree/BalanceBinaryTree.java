package cn.tyrone.java.datastructure.tree;

/**
 * 平衡二叉树
 */
public class BalanceBinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 获取平衡因子
     * @return
     */
    public int getBalanceFactor(){
        int balanceFactor = this.getBalanceFactor(this.root);
        return balanceFactor;
    }

    /**
     * 获取指定结点的平衡因子
     * @param node
     * @return
     */
    public int getBalanceFactor(Node node){
        if (node == null) {
            return 0;
        }
        int leftNodeHeight = getHeight(node.left);
        int rightNodeHeight = getHeight(node.right);
        int balanceFactor = leftNodeHeight - rightNodeHeight;
        return balanceFactor;
    }

    /**
     * 获取树高度
     * @return
     */
    public int getHeight(){
        int height = this.getHeight(this.root);
        return height;
    }

    /**
     * 获取节点高度
     * @param node
     * @return
     */
    public int getHeight(Node node) {

        if (node == null) {
            return 0;
        }

        int leftNodeHeight = getHeight(node.left);
        int rightNodeHeight = getHeight(node.right);

        int nodeHeight = Math.max(leftNodeHeight, rightNodeHeight) + 1;

        return nodeHeight;

    }

    /**
     * 右旋
     * @return
     */
    private Node rightRotate(Node node) {
        Node tempNode = new Node(node.data);
        tempNode.left = node.left.right;
        tempNode.right = node.right;
        node.data = node.left.data;
        node.left = node.left.left;
        node.right = tempNode;
        return tempNode;
    }

    /**
     * 左旋
     * @return
     */
    private Node leftRotate(Node node) {
        Node tempNode = new Node(node.data);
        tempNode.right = node.right.left;
        tempNode.left = node.left;
        node.data = node.right.data;
        node.left = tempNode;
        node.right = node.right.right;
        return tempNode;
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
        boolean ifcontinue = true;
        while (ifcontinue) {

            if (node.data < root.data) {

                Node left = root.left;
                if (left == null) {
                    root.left = node;
                    ifcontinue = false;
                } else {
                    root = left;
                }

            }

            if (node.data > root.data) {

                Node right = root.right;
                if (right == null) {
                    root.right = node;
                    ifcontinue = false;
                } else {
                    root = right;
                }

            }

        }

        int balanceFactor = this.getBalanceFactor();
        System.out.println("当前平衡树平衡因子：" + balanceFactor);

        // LL 右旋
        if (balanceFactor > 1 && node.data < root.data) {
            this.rightRotate(this.root);
            System.out.println("-------- LL平衡结束 --------");
        }

        // LR 先左旋后右旋
        if (balanceFactor > 1 && node.data > root.data) {
            this.leftRotate(this.root.left);
            this.rightRotate(this.root);
            System.out.println("--------- LR平衡结束 ---------");
        }

        // RR 左旋
        if (balanceFactor < -1 && node.data > root.data) {
            this.leftRotate(this.root);
            System.out.println("----- RR平衡结束 -----");
        }

        // RL 先右旋后左旋
        if (balanceFactor < -1 && node.data < root.data) {
            this.rightRotate(this.root.right);
            this.leftRotate(this.root);
            System.out.println("------- RL平衡结束 -------");
        }



    }

    static class Node {

        private int data;

        private Node left;

        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

}
