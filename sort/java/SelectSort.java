package data_structure.sort.java;
/**
 * 选择排序 - 升序排序
 */
public class SelectSort {
    public void sort(int[] nums) {
        for(int i=1; i<nums.length; i++){
            int max = 0;
            for(int j=1; j<nums.length-i; j++){
                if(nums[j] > nums[max]){
                    max = j;
                }
            }
            // 已经找到最大的，交换数据
            if(nums[max] > nums[nums.length-i]){
                int ret = nums[nums.length-i];
                nums[nums.length-i] = nums[max];
                nums[max] = ret;
            }
        }
    }

    /**
     * 同时找到最大和最小值，然后交换数据
     * @param nums
     */
    public void sort1(int[] nums){
        int minSpace = 0;
        int maxSpace = nums.length-1;
        while(maxSpace > minSpace){
            int max = maxSpace;
            int min = minSpace;
            for(int j=minSpace; j<=maxSpace; j++){
                if(nums[j] > nums[max]){
                    max = j;
                }
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            // 已经找到最大的和最小的，交换数据
            if(nums[max] > nums[maxSpace]){
                int ret1 = nums[maxSpace];
                nums[maxSpace] = nums[max];
                nums[max] = ret1;
            }
            if(min == maxSpace){
                min = max;
            }
            if(nums[min] < nums[minSpace]){
                int ret2 = nums[minSpace];
                nums[minSpace] = nums[min];
                nums[min] = ret2;
            }
            maxSpace--;
            minSpace++;
        }
    }
}
