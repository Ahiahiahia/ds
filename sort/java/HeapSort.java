package data_structure.sort.java;

/**
 * 堆排序 - 升序排序，建大堆
 */
public class HeapSort {
    public void sort(int[] nums) {
        heapBuild(nums);
        for(int i=nums.length-1; i>0; i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            AdjustDown(nums,0, i);
        }
    }

    /**
     * 建堆
     * @param nums
     */
    public void heapBuild(int[] nums){
        for(int i=(nums.length-2)/2; i>=0; i--){
            AdjustDown(nums, i, nums.length);
        }
    }

    /**
     * 向下调整
     * @param nums
     * @param root
     */
    public void AdjustDown(int[] nums, int root, int size){
        int max = root;
        while(root<size){
            int left = 2*root+1;
            int right = 2*root+2;
            // 判断是否有孩子节点
            if(left >= size){
                break;
            }
            // 右节点存在，且右节点大于左节点
            if(right<size && nums[right]>=nums[left]){
                max = right;
            }
            // 右节点不存在，或左节点大于右节点
            else{
                max = left;
            }
            if(nums[root] < nums[max]){
                int temp = nums[root];
                nums[root] = nums[max];
                nums[max] = temp;
                root = max;
            }else{
                break;
            }
        }
    }
}
