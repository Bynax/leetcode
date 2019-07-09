/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */
class Solution {
    public static int kthSmallest(int[][] matrix, int k) {
        return kthSmallestImp(matrix, k);
    }

    /**
     * 使用二分搜索数显 kth smallest
     * @param matrix
     * @param k
     * @return
     */
    static int kthSmallestImp(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        int middle;
        int count;
        while (left <= right) {
            middle = left + (right - left) / 2;
            count = getLessOrEqual(matrix, middle);
            if (count < k) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    /**
     * 寻找矩阵中小于等于特定元素的个数
     * @param matrix
     * @param val
     * @return
     */
    static int getLessOrEqual(int[][] matrix, int val) {
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        int resultIndex = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > val) {
                row--;
            } else {
                resultIndex += row + 1;
                col++;
            }
        }
        return resultIndex;
    }
}
