package data_structure.list.java;

/**
 * 双向链表
 */
interface ILink{
    /**
     * 增加节点
     * @param data 要添加节点的内容
     * @return 返回是否添加成功
     */
    boolean add(Object data);

    /**
     * 删除指定节点
     * @param data 要删除的节点内容
     * @return
     */
    boolean remove(Object data);

    /**
     * 修改指定下标的节点内容
     * @param data 要修改的内容
     * @param index 指定下标值
     * @return
     */
    boolean set(Object data, int index);

    /**
     * 取得指定下标的节点
     * @param index 下标值
     * @return 返回节点内容
     */
    Object get(int index);

    /**
     * 将链表转化为数组
     * @return 返回一个数组
     */
    Object[] toArray();

    /**
     * 取得链表长度
     * @return
     */
    int size();

    /**
     * 打印链表
     */
    void print();

    /**
     * 清空一个链表
     */
    void clear();
}
class ILinkImpl implements ILink{
    private Node head;
    private Node last;
    private int size;
    class Node{
        private Node prev;
        private Node next;
        private Object data;

        public Node(Node prev, Node next, Object data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    @Override
    public boolean add(Object data) {
        Node temp = this.last;
        Node newNode = new Node(temp,null,data);
        this.last = newNode;
        if(this.head == null){
            this.head = newNode;
        }else{
            temp.next = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object data) {
        Node temp = findNode(data);
        if(temp == null){
            System.out.println("没有找到该节点");
            return false;
        }else if(temp == this.head){
            this.head = temp.next;

        }else if(this.last == temp){
            this.last = temp.prev;
        }else{
            Node ret = temp;
            temp.prev.next = ret.next;
            temp.next.prev = ret.prev;
        }
        temp.data = null;
        temp = temp.prev = temp.next = null;
        this.size--;
        return true;
    }

    @Override
    public boolean set(Object data, int index) {
        Node temp = findIndex(index);
        if(temp == null){
            System.out.println("下标超出范围");
            return false;
        }
        temp.data = data;
        return true;
    }

    @Override
    public Object get(int index) {
        Node temp = findIndex(index);
        if(temp == null){
            System.out.println("下标超出范围");
            return false;
        }
        return temp.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void print() {
        Object[] array = this.toArray();
        for(Object obj : array){
            System.out.print(obj+" ");
        }
        System.out.println();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        Node temp = this.head;
        for(int i=0; i<this.size; i++){
            array[i] = temp.data;
            temp = temp.next;
        }
        return array;
    }

    @Override
    public void clear() {
        Node temp = this.head;
        Node ret = null;
        for(; temp!=null; temp=ret){
            ret = temp.next;
            temp.data = null;
            temp = temp.prev = temp.next = null;
            this.size--;
        }
    }

    /**
     * 根据节点内容返回该节点
     * @param data 要查找的节点内容
     * @return
     */
    private Node findNode(Object data){
        Node temp = this.head;
        if(data == null){
            for(; temp!=null; temp=temp.next){
                if(temp.data == null){
                    return temp;
                }
            }
        }else{
            for(; temp!=null; temp=temp.next){
                if(temp.data == data){
                    return temp;
                }
            }
        }
        return null;
    }

    /**
     * 根据下标查找指定节点
     * @param index 要查找的节点下标
     * @return
     */
    private Node findIndex(int index){
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