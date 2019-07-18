/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */
class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        return longestCommonPrefixNormalImp(strs);
    }

    /**
     * 使用一般的解法解决LCP的问题
     * @param strs
     * @return
     */
    static String longestCommonPrefixNormalImp(String[] strs) {
        if (strs == null) { // 初始化条件
            return "";
        }
        int strsLength = strs.length;
        if (strsLength == 0) { // 初始化条件，因为想要节省计算strs的长度所以分开
            return "";
        }

        String prefix = strs[0]; // 将prefix设置为第一个元素
        int prefixLength = prefix.length(); // 记录prefix的长度
        for (int i = 1; i < strsLength; i++) {
            while (strs[i].indexOf(prefix) != 0) { // 因为是前缀，因此一定要是从第一个元素开始就相同
                prefix = prefix.substring(0, prefixLength - 1); // 不匹配就减少一个元素
                prefixLength--; // 更新prefix的长度
                if (prefixLength == 0) { // 表明此时已经没有LCP
                    return ""; 
                }
            }
        }
        return prefix;

    }
}
