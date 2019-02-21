package data_structure.sort.java;

/**
 * 主方法
 */
public class MainObj{
    public static void main(String[] args){
        int[] nums = new int[]{5,7,3,9,2,6,2,8,4,1};
        printArray(nums);
        System.out.println();
        new XierSort().sort(nums, nums.length/3+1);
        printArray(nums);
    }

    /**
     * 打印元素
     * @param nums
     */
    public static void printArray(int[] nums){
        for(int n : nums){
            System.out.print(n + "、");
        }
    }
}
