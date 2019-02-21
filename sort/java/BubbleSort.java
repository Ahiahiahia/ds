package data_structure.sort.java;

/**
 * 冒泡排序 - 升序排序
 */
public class BubbleSort {
    public void sort(int[] nums) {
        boolean flag = true;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<nums.length-i; j++){
                if(nums[j] > nums[j+1]){
                    int key = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = key;
                    flag = false;
                }
            }
            // 如果某趟下来没有交换元素，则表明元素以及有序，无须再排序
            if(flag){
                break;
            }
        }
    }
}
