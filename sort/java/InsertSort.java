package data_structure.sort.java;

/**
 * 插入排序 - 升序排序
 */
public class InsertSort{
    public void sort(int[] nums){
        // i 表示待排序元素下标
        for(int i=1; i<nums.length; i++){
            int key = nums[i];
            // j 表示已排好序的元素下标
            int j = 0;
            for(j=i-1; j>=0; j--){
                if(key >= nums[j]){
                    break;
                }else{
                    nums[j+1] = nums[j];
                }
            }
            nums[j+1] = key;
        }
    }
}
