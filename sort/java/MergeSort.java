package data_structure.sort.java;
/**
 * 归并排序 - 升序排序
 */
public class MergeSort {

    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid);
            sort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }
    }

    public void merge(int[] nums, int left, int center, int right) {
        int[] temp = new int[nums.length];
        int mid = center+1;
        int cacheLeft = left;
        int third = left;

        // 将较小的元素拷贝到临时数组
        while (left <= center && mid <= right) {
            if (nums[left] <= nums[mid]) {
                temp[third++] = nums[left++];
            } else {
                temp[third++] = nums[mid++];
            }
        }
        // 右边多了
        while (mid <= right) {
            temp[third++] = nums[mid++];
        }
        // 左边多了
        while (left <= center) {
            temp[third++] = nums[left++];
        }
        // 将数据拷贝回原数组
        while (cacheLeft <= right) {
            nums[cacheLeft] = temp[cacheLeft++];
        }
    }
}
