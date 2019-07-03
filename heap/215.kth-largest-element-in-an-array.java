/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */
class Solution {
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargestPartation(nums, k);

    }

    /**
     * 使用快速排序中partition的思想找第k大元素的方法
     * 
     * @param nums 给定数组
     * @param k    寻找第k大的元素
     * @return
     */
    static int findKthLargestPartation(int[] nums, int k) {

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int pivot = partation(nums, start, end); // 经过partition之后，找到了第pivot大的元素。
            if (pivot < k - 1) { // 因为pivot表示的是下标，因此与k-1相比
                start = pivot + 1; // 小于的话表示在右半部分
            } else if (pivot > k - 1) {
                end = pivot - 1; // 表示在左半部分
            } else {
                return nums[pivot];
            }

        }
        return nums[end];

    }

    /**
     * 对给定数组执行partition的操作，经过partition操作后可以确定一个元素的最终位置
     * 
     * @param nums  给定数组
     * @param start partition操作的开始位置
     * @param end   partition操作结束的位置
     * @return
     */
    static int partation(int[] nums, int start, int end) {
        int pivot = start;
        // 大于的在左边，小于的在右边
        while (start < end) {
            while (start <= end && nums[start] >= nums[pivot]) {
                start++;
            }
            while (start <= end && nums[end] < nums[pivot]) {
                end--;
            }
            if (start >= end) {
                break;
            }

            // 交换
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];

        }
        if (end == pivot) {
            return end; // 防止同一个元素交换时候会出现等于0的情况
        }
        // 交换
        nums[end] = nums[end] ^ nums[pivot];
        nums[pivot] = nums[end] ^ nums[pivot];
        nums[end] = nums[end] ^ nums[pivot];
        return end;
    }
}
