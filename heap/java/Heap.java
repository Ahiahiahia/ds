package data_structure.heap.java;

/**
 * 二叉堆 - 数组实现
 */
public class Heap {
    private int[] array;    // 存放堆元素
    private int size;   // 当前堆的元素个数
    private int root;   // 当前堆顶元素

    public Heap(int[] array, int size) {
        this.array = array;
        this.size = size;
    }

    /**
     * 向下调整(小堆) - 前提是root所在的节点左右子树已经满足了堆的性质
     * @param array 要向下调整的堆数组
     * @param root 要调整的节点的下标
     */
    public void adjustDown(int[] array, int root){
        int left = 2*root+1;    // 左孩子节点下标
        int right = 2*root+2;   // 右孩子节点下标
        int min = root;    // 最小的孩子节点

        // 没有孩子节点
        if(left >= this.size-1){
            return;
        }
        // 有右孩子节点,并且右孩子小于左孩子
        if(right < this.size && array[right] < array[left]){
            min = right;
        }else{
            // 没有右孩子节点，或者左孩子大于右孩子
            min = left;
        }
        // 比较min节点与root节点
        if(array[root] <= array[min]){
            return;
        }
        int temp = array[root];
        array[root] = array[min];
        array[min] = temp;
        adjustDown(array, min);
    }

    /**
     * 建堆
     */
    public void createHeap(){
        for(int i=(this.size-2)/2; i>=0; i--){
            adjustDown(this.array, i);
        }
    }

    /**
     * 删除元素
     * @param k 要删除的元素
     */
    public void popHeap(int k){
        int i = 0;
        for(i=0; i<this.size; i++){
            if(this.array[i] == k){
                break;
            }
        }
        if(i >= this.size){
            System.out.println("没有找到该元素");
            return;
        }
        this.array[i] = this.array[this.size-1];
        // 删除最后的元素
        this.size--;
        adjustDown(this.array, i);
    }

    /**
     * 插入元素
     * @param k 要插入的元素
     */
    public void insertHeap(int k){
        int len = this.size;
        this.size++;
        int[] nums = new int[this.size];
        for(int i=0; i<len; i++){
            nums[i] = this.array[i];
        }
        nums[this.size-1] = k;
        this.array = nums;
        adjustUp(this.array, this.size-1);
    }

    /**
     * 向上调整 - 小堆
     * @param array
     * @param child 要向上调整的节点下标
     */
    public void adjustUp(int[] array, int child){
        while(child != 0){
            int parent = (child-1)/2;
            if(array[child] >= array[parent]){
                return;
            }
            int temp = array[child];
            array[child] = array[parent];
            array[parent] = temp;
            child = parent;
        }
    }

    /**
     * 打印堆
     */
    public void printHeap(){
        for(int i=0; i<this.size; i++){
            System.out.print(this.array[i] + " ");
        }
    }
}
