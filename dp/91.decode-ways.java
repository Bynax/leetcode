/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */
class Solution {
    public int numDecodings(String s) {
        return numDecodingsDp(s);

    }

    /**
     * 使用动态规划实现
     * 
     * @param s
     * @return
     */
    int numDecodingsDp(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int length = s.length() + 1;
        int[] dp = new int[length];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < length; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[length - 1];

    }
}
