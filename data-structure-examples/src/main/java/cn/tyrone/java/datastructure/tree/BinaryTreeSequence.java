package cn.tyrone.java.datastructure.tree;

/**
 * 顺序存储二叉树
 */
public class BinaryTreeSequence {

    private int[] data;

    public BinaryTreeSequence(int[] data) {
        this.data = data;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    /**
     * 先序遍历
     * 根节点--左节点--右节点
     */
    public void preOrder(int index) {

        if (this.data == null || this.data.length == 0) {
            return;
        }

        System.out.println(this.data[index]);

        int leftNodeIndex = 2 * index + 1;
        if (leftNodeIndex < this.data.length) {
            preOrder(leftNodeIndex);
        }

        int rightNodeIndex = 2 * index + 2;
        if (rightNodeIndex < this.data.length) {
            preOrder(rightNodeIndex);
        }

    }

}
