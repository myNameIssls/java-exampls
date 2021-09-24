package cn.tyrone.java.datastructure.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedList<T> {

    /**
     * 当前节点
     */
    private Node<T> node;

    /**
     * 向链表尾部添加
     * @param data
     * @return
     */
    public DoubleLinkedList add(T data){

        Node newNode = new Node(data);

        Node node = this.node;

        // 如果当前节点为空，则当前节点等于添加的节点
        if (node == null) {
            this.node = newNode;
            return this;
        }

        while (true) {
            Node next = node.next;
            if (next == null) {
                node.next = newNode;
                newNode.prev = node;
                break;
            }
            node = node.next;
        }

        return this;
    }


    private class Node<T> {

        /**
         * 节点数据
         */
        private T data;

        /**
         * 下一个节点
         */
        private Node<T> prev;

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
