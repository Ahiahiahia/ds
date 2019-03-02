package data_structure.sort.java;
/**
 * 快速排序 - 升序排序
 */
public class QuickSort {
    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            //[left, right]
            //1. mid  (cur  = left , pre = cur -1 , key = nums[cur] )
            // cur ->  pre ->
            //2. sort
            int div = pation2(nums, left, right);
            sort(nums, left, div-1);
            sort(nums, div + 1, right);
        }
    }

    /**
     * hoare方式
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int pation1(int[] nums, int left, int right) {
        int begin = left;
        int end = right;
        int key = nums[left];
        while (begin < end) {
            // 从前往后找比基准值大的元素
            while (begin < end && nums[begin] <= key) {
                begin++;
            }
            // 从后往前找比基准值小的元素
            while (begin < end && nums[end] >= key) {
                end--;
            }
            if (begin < end) {
                int ret = nums[end];
                nums[end] = nums[begin];
                nums[begin] = ret;
            }
        }
        if (end != left) {
            int ret = key;
            nums[left] = nums[end - 1];
            nums[end - 1] = ret;
        }
        return end - 1;
    }

    /**
     * 挖坑法
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int pation2(int[] nums, int left, int right) {
        int begin = left;
        int end = right;
        int key = nums[left];
        while (begin < end) {
            while (begin < end && nums[end] >= key) {
                end--;
            }
            if (begin < end) {
                nums[begin] = nums[end];
                begin++;
            }
            while (begin < end && nums[begin] <= key) {
                begin++;
            }
            if (begin < end) {
                nums[end] = nums[begin];
                end--;
            }
        }
        nums[end] = key;
        return end;
    }

    /**
     * 前后指针法
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    /**
     * 例子：
     * 原始数据：2 1 5 3 4   ,key = 4
     * cur = 0  prev = 0
     * cur = 1  prev = 1
     * cur = 2  prev = 1
     * cur = 3  prev = 2    , 2 1 3 5 4
     * cur = 4  prev = 3    , 2 1 3 4 5
     * sort(nums, 0, 2)  2 1 3
     * sort(nums, 4, 4)  5
     */
    public int pation3(int[] nums, int left, int right) {
        int cur = left;
        int prev = cur - 1;
        int key = nums[right];
        while (cur <= right) {
            if (nums[cur] <=key) {
                prev++;
                if (prev != cur) {
                    int ret = nums[cur];
                    nums[cur] = nums[prev];
                    nums[prev] = ret;
                }
            }
            cur++;
        }
        // 返回key值下标
        return prev;
    }

    // 递归转循环
}
