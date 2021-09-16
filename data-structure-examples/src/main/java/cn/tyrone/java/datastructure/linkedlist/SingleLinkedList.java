package cn.tyrone.java.datastructure.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedList<T> {

    /**
     * 当前节点
     */
    private Node<T> currentNode;

    /**
     * 链表的长度
     */
    private int size;

    public SingleLinkedList(){}

    /**
     * 在链表最后的节目上追加一个节点
     * @param data
     * @return
     */
    public SingleLinkedList append(T data){

        Node newNode = new Node(data);

        Node<T> currentNode = this.currentNode;

        // 如果当前节点为空，则当前节点等于添加的节点
        if (currentNode == null) {
            this.currentNode = newNode;
            this.size = 1;
        }

        // 循环判断当前节点下一个节点是否为空，如果为空，为当前节点的下一下节点添加新的节点
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode != null) {
                currentNode = nextNode;
                continue;
            }
            if (nextNode == null) {
                currentNode.next = newNode;
                this.size++;
                break;
            }
        }

        return this;
    }

    /**
     * 返回链表长度
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * 循环输出链表中内容
     */
    public void print(){
        while (this.currentNode != null) {
            System.out.println(this.currentNode.data);
            this.currentNode = this.currentNode.next;
        }
    }

    private class Node<T> {

        /**
         * 节点数据
         */
        private T data;

        /**
         * 下一个节点
         */
        private Node<T> next;

        Node(){
            this.data = null;
        }

        Node(T data){
            this.data = data;
        }

    }

}