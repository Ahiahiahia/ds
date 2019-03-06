package data_structure.stackAndqueue.java;

// 栈 - 先进后出
// 链表实现栈 - 头插头删
interface IStack{
    /**
     * 压栈
     * @param data 压栈的内容
     * @return
     */
    boolean pushStack(Object data);

    /**
     * 取得栈顶内容
     * @return
     */
    Object topStack();

    /**
     * 出栈
     * @return
     */
    boolean popStack();

    /**
     * 打印栈
     */
    void printStack();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
}
class IStackImpl implements IStack{
    private Node head;  // 栈顶
    private int size;   // 当前栈容量
    private class Node{
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    @Override
    public boolean pushStack(Object data) {
        Node newNode = new Node(data,head);
        head = newNode;
        this.size++;
        return true;
    }

    @Override
    public Object topStack() {
        if(isEmpty()){
            System.out.println("栈为空");
            return false;
        }
        return head.data;
    }

    @Override
    public boolean popStack() {
        if(isEmpty()){
            return false;
        }
        head = head.next;
        this.size--;
        return true;
    }

    @Override
    public void printStack() {
        if(isEmpty()){
            System.out.println("栈为空");
        }
        while(!isEmpty()){
            Object ret = topStack();
            popStack();
            System.out.print(ret + "、");
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return this.size<=0;
    }
}
