package data_structure.list.java;

/**
 * 单链表
 */
interface  ISingleLink {
    // 头增
    void addHead(Object data);

    // 尾增
    void addTail(Object data);

    // 在index位置后增
    void addIndex(Object data, int index);

    // 头删
    void removeHead();

    // 尾删
    void removeTail();

    // 修改下标为index的节点
    boolean set(int index, Object data);

    // 取得下标为index的节点值
    Object get(int index);

    // 取得节点个数
    int getSize();

    // 打印链表
    void print();

    // 清空链表
    void clear();
}

class SingleLinkImpl implements ISingleLink{
        private Node last;  // 当前链表的尾节点
        private Node head;  // 当前链表的头节点
        private int size;   // 链表长度
        // 链表节点类
        class Node{
            private Node next;
            private Object data;

            public Node(Node next, Object data) {
                this.next = next;
                this.data = data;
            }
        }
    @Override
    public void addHead(Object data) {
        Node newNode = new Node(null, data);
        if(this.head == null){
            this.head = newNode;
            this.last = newNode;
        }else{
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void addTail(Object data) {
        Node newNode = new Node(null, data);
        if(this.head == null){
            this.head = newNode;
            this.last = newNode;
        }else{
            this.last.next = newNode;
            this.last = newNode;
        }
        this.size++;
    }

    @Override
    public void addIndex(Object data, int index) {
        Node newNode = new Node(null, data);
        Node temp = findNode(index);
        if(temp == null){
            System.out.println("没有找到该节点！");
        }
        newNode.next = this.head.next;
        this.head.next = newNode;
        this.size++;
    }

    @Override
    public void removeHead() {
        if(this.head == this.last){
            this.head.data = null;
            this.head = this.head.next = null;
            this.last = null;
        }else{
            Node ret = this.head;
            this.head = this.head.next;
            ret.data = null;
            ret = ret.next = null;
        }
        this.size--;
    }

    @Override
    public void removeTail() {
        if(this.head == this.last){
            this.head.data = null;
            this.head = this.head.next = null;
            this.last = null;
        }else{
            Node temp = findNode(this.size-2);
            Node ret = this.last;
            temp.next = null;
            ret.data = null;
            ret = ret.next = null;
        }
        this.size--;
    }

    @Override
    public boolean set(int index, Object data) {
        Node temp = findNode(index);
        if(temp == null){
            System.out.println("没有找到该节点！");
            return false;
        }
        temp.data = data;
        return true;
    }

    @Override
    public Object get(int index) {
        return findNode(index).data;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void print() {
        Object[] objs = listToCharArray();
        for(Object obj : objs){
            System.out.print(obj + "、");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        Node temp = this.head;
        Node ret = null;
        for(; temp!=null; temp=ret){
            ret = temp.next;
            temp.data = null;
            temp = temp.next = null;
            this.size--;
        }
    }

    // 将链表转化为数组
    private Object[] listToCharArray(){
        Object[] objs = new Object[this.size];
        Node temp = this.head;
        for(int i=0; i<this.size; i++){
            objs[i] = temp.data;
            temp=temp.next;
        }
        return objs;
    }

    // 查找下标为index的节点
    private Node findNode(int index){
        if(index<0 || index>this.size){
            return null;
        }
        Node temp = this.head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }
}

