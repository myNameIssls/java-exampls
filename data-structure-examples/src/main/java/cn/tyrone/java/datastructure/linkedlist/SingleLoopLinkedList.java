package cn.tyrone.java.datastructure.linkedlist;

/**
 * 单向循环链表
 */
public class SingleLoopLinkedList<T> {

    /**
     * 当前节点
     */
    private Node<T> node;
    
    /**
     * 向链表尾部添加
     * @param data
     * @return
     */
    public SingleLoopLinkedList add(T data){

        Node newNode = new Node(data);

        Node node = this.node;

        // 如果当前节点为空，则当前节点等于添加的节点
        if (node == null) {
            this.node = newNode;
            this.node.next = newNode;
            return this;
        }

        while (true) {

            if (node.next.equals(this.node)) {
                node.next = newNode;
                newNode.next = this.node;
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
        private Node<T> next;

        Node(){
            this.data = null;
        }

        Node(T data){
            this.data = data;
        }

    }

}
