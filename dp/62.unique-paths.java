/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */
class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathsDp(m, n);
    }

    /**
     * 使用递归的方法实现uniquePaths(TIMEOUT)
     * 
     * @param m
     * @param n
     * @return
     */
    int uniquePathsRec(int m, int n) {
        return uniquePathsRecHelper(1, 1, m, n);
    }

    /**
     * 递归辅助函数
     * 
     * @param row 当前行
     * @param col 当前列
     * @param m   总行数
     * @param n   总列数
     * @return
     */
    int uniquePathsRecHelper(int row, int col, int m, int n) {
        if (row == m && col == n) {
            return 1;
        }
        if (row == m) {
            return uniquePathsRecHelper(row, col + 1, m, n);
        }
        if (col == n) {
            return uniquePathsRecHelper(row + 1, col, m, n);
        }
        return uniquePathsRecHelper(row, col + 1, m, n) + uniquePathsRecHelper(row + 1, col, m, n);
    }

    /**
     * 使用动态规划实现uniquePaths
     * 
     * @param m
     * @param n
     * @return
     */
    int uniquePathsDp(int m, int n) {
        int[][] dp = new int[m][n]; // 设置辅助数组
        // 初始化
        dp[m-1][n-1] = 1;
        // 初始化最后一列
        for (int i = m-2; i >= 0; i--) {
            dp[i][n-1] = dp[i+1][n-1];
        }
        // 初始化最后一行
        for (int i = n-2; i >=0; i--) {
            dp[m-1][i] = dp[m-1][i+1];
        }

        // 对于一般情况进行计算
        for (int i = m-2; i >=0; i--) {
            for (int j = n-2; j>=0; j--) {
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }

        return dp[0][0]; // 返回结果
    }

}
