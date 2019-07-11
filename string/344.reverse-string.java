/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */
class Solution {
    /**
     * 字符串逆序
     * 
     * @param s
     */
    public static void reverseString(char[] s) {
        reverseStringImp(s);
    }

    /**
     * 使用双指针交换的方法实现字符串逆序
     * @param s
     */
    static void reverseStringImp(char[] s) {
        if (s == null) { // 边界条件
            return;
        }
        int sLenght = s.length;
        if (sLenght <= 1) { // 边界条件
            return;
        }

        int start = 0;
        int end = sLenght - 1;
        while (start < end) {
            // 交换两个元素
            s[start] = (char) (s[start] ^ s[end]);
            s[end] = (char) (s[start] ^ s[end]);
            s[start] = (char) (s[start] ^ s[end]);
            start++; // 更新start
            end--; // 更新end
        }

    }
}
