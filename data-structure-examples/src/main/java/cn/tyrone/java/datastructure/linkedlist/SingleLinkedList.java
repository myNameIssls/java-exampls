package cn.tyrone.java.datastructure.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedList<T> {

    /**
     * 当前节点
     */
    private Node<T> node;
    
    /**
     * 向链表尾部添加
     * @param data
     * @return
     */
    public SingleLinkedList add(T data){

        Node newNode = new Node(data);

        Node node = this.node;

        // 如果当前节点为空，则当前节点等于添加的节点
        if (node == null) {
            this.node = newNode;
            return this;
        }

        // 循环判断当前节点下一个节点是否为空，如果为空，为当前节点的下一下节点添加新的节点
        while (node != null) {
            Node nextNode = node.next;
            if (nextNode != null) {
                node = nextNode;
                continue;
            }
            if (nextNode == null) {
                node.next = newNode;
                break;
            }
        }

        return this;
    }

    /**
     * 通过一个数组初始化一个链表
     * @param dataArray
     */
    public void initFromArrays(T[] dataArray){
        if (dataArray == null || dataArray.length == 0) {
            throw new RuntimeException("数组为空");
        }

        for (T data : dataArray) {
            this.add(data);
        }
    }

    /**
     * 返回链表长度
     * @return
     */
    public int size(){

        int size = 0;
        Node<T> node = this.node;
        while (node != null) {

            size++;

            Node<T> next = node.next;
            if (next == null) {
                break;
            }
            node = next;
        }
        return size;
    }

    /**
     * 当前链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.node == null;
    }

    @Override
    public String toString() {

        Node<T> node = this.node;

        StringBuffer sb = new StringBuffer("[");
        while (node != null) {
            sb.append(node.data).append(",");
            node = node.next;
        }
        sb.append("]");

        if (!this.isEmpty()) {
            int lastIndexOf = sb.lastIndexOf(",");
            sb.deleteCharAt(lastIndexOf);
        }

        return sb.toString();
    }

    /**
     * 链表中奇数位与偶数交易位置
     * 输入[a,1,b,2,c,3]
     * 输出[1,a,2,b,3,c]
     */
    public void oddEvenSwap(){

        SingleLinkedList<T> temp = new SingleLinkedList<>();

        int index = 0;
        // 奇数位节点
        Node<T> oddNode = null;
        // 偶数位节点
        Node<T> evenNode = null;

        Node<T> node = this.node;

        while (node != null) {

            index++;

            // 奇数
            if (index % 2 != 0) {
                // 设置奇数位node
                oddNode = node;

                Node<T> next = node.next;
                if (next != null) {
                    index++;
                    evenNode = next;
                }

                node = next.next;

            }
            temp.add(evenNode.data).add(oddNode.data);
        }

        this.node = temp.node;

    }

    /**
     * 返回数据
     * @return
     */
    public T getData(){
        return this.node.data;
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
