/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    public static String longestPalindrome(String s) {
        return longestPalindromStringManacher(s);

    }

    /**
     * 使用Manacher算法实现最长回文
     * 
     * @param s
     * @return
     */
    static String longestPalindromStringManacher(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        char[] sArray = prePreocessStr(s); // 对s进行预处理
        int sLength = 2 * length + 1; // s经过处理后的长度
        int[] rArray = new int[sLength]; // 标记该点为中心的最大回文半径

        int R = -1; // 最右回文边界
        int id = -1; // 当前回文右边界对应的中心点
        int maxIndex = -1; // 最长时候中心点的下标
        int maxLength = -1; // 当前最长回文长度

        for (int i = 0; i < sLength; i++) {
            rArray[i] = i < R ? Math.min(R - i, rArray[2 * id - i]) : 1; // 寻找下界
            // 开始扩充
            while (i + rArray[i] < sLength && i - rArray[i] > -1) {
                if (sArray[i + rArray[i]] == sArray[i - rArray[i]]) { // 
                    rArray[i]++;
                } else {
                    break;
                }
            }
            if (i + rArray[i] > R) { // 更新最右回文边界
                R = i + rArray[i];
                id = i;
            }
            if (rArray[i] > maxLength) { // 更新最大长度及长度对应中心
                maxLength = rArray[i];
                maxIndex = i;
            }

        }
        maxLength = maxLength - 1; //
        return s.substring((maxIndex - maxLength) >> 1, (maxIndex + maxLength + 1) >> 1);
    }

    /**
     * 对要进行回文搜索的字符串进行预处理 预处理的方式就是在开头和中间加入特殊字符
     * 
     * @param s
     * @return
     */
    static char[] prePreocessStr(String s) {
        // 假设传入的参数都是有效的，应该在预处理前就进行输入有效性的判断
        int length = s.length();
        char[] results = new char[2 * length + 1];
        for (int i = 0; i < 2 * length + 1; i++) {
            results[i] = (i & 1) == 0 ? '#' : s.charAt(i / 2);
        }
        return results;

    }
}
