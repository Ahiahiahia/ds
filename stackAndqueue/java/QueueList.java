package data_structure.stackAndqueue.java;

// 队列 - 先进先出
// 链表实现队列 - 尾插头删
interface IQueue{
    /**
     * 入队列
     * @param data 入队列的元素
     * @return
     */
    boolean pushQueue(Object data);

    /**
     * 返回队头内容
     * @return
     */
    Object headQueue();

    /**
     * 出队列
     * @return
     */
    boolean popQueue();

    /**
     * 打印队列
     */
    void printQueue();
}

class IQueueImpl implements IQueue{
    private Node head;  // 队头
    private Node last;  // 队尾
    private int size;   // 当前队列容量
    class Node{
        private Node next;
        private Object data;

        public Node(Node next, Object data) {
            this.next = next;
            this.data = data;
        }
    }

    @Override
    public boolean pushQueue(Object data) {
        Node newNode = new Node(null, data);
        if(isEmpty()){
            this.head = this.last = newNode;
        }else{
            this.last.next = newNode;
            this.last = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public Object headQueue() {
        if(isEmpty()){
            System.out.println("队列为空");
            return false;
        }
        return this.head.data;
    }

    @Override
    public boolean popQueue() {
        if(isEmpty()){
            System.out.println("队列为空");
            return false;
        }else{
            this.head = this.head.next;
            this.size--;
        }
        return true;
    }

    @Override
    public void printQueue() {
        if(isEmpty()){
            System.out.println("队列为空");
        }else{
            while(!isEmpty()){
                Object ret = headQueue();
                popQueue();
                System.out.print(ret + "、");
            }
            System.out.println();
        }
    }

    //判断队列是否为空
    private boolean isEmpty(){
        return this.size<=0;
    }
}
