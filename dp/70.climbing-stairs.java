/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */
class Solution {
    public int climbStairs(int n) {
        return climbStairsDp(n);
    }

    int climbStairsDp(int n){
        if(n<1){
            return 0;
        }
        if(n<3){
            return n;
        }
        int pre_pre = 1;
        int pre = 2;
        int result = 0;
        for (int i = 3; i <=n ; i++) {
            result = pre_pre+pre;
            pre_pre = pre;
            pre = result;
        }
        return result;
    }
}
