package data_structure.sort.java;

/**
 * 希尔排序 - 升序排序
 * 直接插入排序的优化
 */
public class XierSort{
    public void sort(int[] nums, int grap) {
//        for(int i=grap; i<nums.length; i++){
//            int j = 0;
//            int key = nums[i];
//            for(j=i-grap; j>=0; j-=grap){
//                if(key >= nums[j]){
//                    break;
//                }else{
//                    nums[j+grap] = nums[j];
//                }
//            }
//            nums[j+grap] = key;
//        }
//        // grap !=1 时称为预排序
//        if(grap != 1){
//            sort(nums, grap/3+1);
//        }

        for(int i=0; i<grap; i++){
            int j = i+grap;
            while(j<nums.length){
                int key = nums[j];
                int k = j-grap;
                while(k>=0){
                    if(key >= nums[k]){
                        break;
                    }else{
                        nums[k+grap] = nums[k];
                        k = k-grap;
                    }
                }
                nums[k+grap] = key;
                j = j+grap;
            }
        }
        if(grap != 1){
            sort(nums, grap/3+1);
        }
    }
}
