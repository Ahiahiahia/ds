package data_structure.list.java;

/**
 * 双向循环链表
 */
interface  ICycleLink {
    /**
     * 链表增加节点操作
     * @param data 节点内容
     * @return
     */
    boolean add(Object data);

    /**
     * 判断指定内容节点在链表中是否存在
     * @param data 要判断的内容
     * @return 返回找到的节点索引
     */
    int contains(Object data);

    /**
     * 删除指定内容节点
     * @param data
     * @return
     */
    boolean remove(Object data);

    /**
     * 根据指定下标修改节点内容
     * @param index 索引下标
     * @param newData 替换后的内容
     * @return 替换之前的节点内容
     */
    Object set(int index,Object newData);

    /**
     * 根据指定下标返回节点内容
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * 链表清空
     */
    void clear();

    /**
     * 将链表转为数组
     * @return 返回所有节点内容
     */
    Object[] toArray();

    /**
     * 链表长度
     * @return
     */
    int size();

    /**
     * 遍历链表
     */
    void printLink();
}
class ICycleLinkImpl implements ICycleLink{
    private Node head;
    private Node last;
    private int size;
    private class Node{
        private Object data;
        private Node prev;
        private Node next;
        public Node(Object data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    @Override
    public boolean add(Object data) {
        Node temp = this.last;
        Node newNode = new Node(data,last,null);
        last = newNode;
        if(head == null){
            head = newNode;
        }else{
            temp.next = newNode;
            newNode.next = head;
        }
        this.size++;
        return true;
    }

    @Override
    public int contains(Object data) {
        Node temp = this.head;
        int i=0;
        if(data == null){
            for(; temp!=null; temp=temp.next) {
                if (temp.data == null) {
                    return i;
                }
                i++;
            }
        }else{
            for(; temp!=null; temp=temp.next){
                if(temp.data == data){
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object data) {
        Node temp = this.head;
        if(data == null){
            for(; temp!=null; temp=temp.next){
                if(temp.data == null){
                    removeNode(temp);
                    return true;
                }
            }
        }else{
            for(; temp!=null; temp=temp.next){
                if(temp.data == data){
                    removeNode(temp);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        if(!isIndex(index)){
            return null;
        }
        Node temp = node(index);
        Object ret = temp.data;
        temp.data = newData;
        return ret;
    }

    @Override
    public Object get(int index) {
        if(!isIndex(index)){
            return null;
        }
        return node(index).data;
    }

    @Override
    public void clear() {
        Node ret;
        for(Node temp = this.head; temp!=null; temp=ret){
            ret = temp.next;
            temp.data = null;
            temp = temp.next = null;
            this.size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size];
        Node temp = this.head;
        for(int i=0; i<this.size; i++){
            result[i] = temp.data;
            temp = temp.next;
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printLink() {
        Object[] result = this.toArray();
        for(Object temp:result){
            System.out.println(temp);
        }
    }
    private boolean isIndex(int index){
        return index<this.size && index>=0;
    }
    private Node node(int index){
        if(index<(this.size>>1)){
            Node temp = this.head;
            for(int i=0; i<index; i++){
                temp = temp.next;
            }
            return temp;
        }else{
            Node temp = this.last;
            for(int i=size-1; i>index; i--){
                temp = temp.prev;
            }
            return temp;
        }
    }
    private void removeNode(Node temp){
        Node prev = temp.prev;
        Node next = temp.next;
        if(this.head == null){
            this.head = next;
            head.prev = this.last;
        }else{
            prev.next = next;
            next.prev = prev;
        }
        if(this.last == null){
            this.last = prev;
            last.next = this.head;
        }else{
            prev.next = next;
            next.prev = prev;
        }
        temp.data = null;
        temp.next = temp.prev = null;
        this.size--;
    }
}
