/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */
class Solution {
    public static int strStr(String haystack, String needle) {
        return strStrImp(haystack, needle);
    }

    /**
     * 使用KMP的方法进行字符串匹配
     * 
     * @param haystack 相当于KMP中的string
     * @param needle   相当于KMP中的pattern
     * @return
     */
    static int strStrImp(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if (haystackLength < needleLength) {
            return -1; // 边界情况检测
        }
        if(needleLength==0){
            return 0; // 边界情况检测
        }
        int[] next = getNext(needle); // 获取next数组
        int haystackIndex = 0;
        int needleIndex = 0;

        while (haystackIndex < haystackLength) {
            if (haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) { // 匹配
                haystackIndex++;
                needleIndex++;
            } else { // 不匹配
                if (needleIndex != 0) {
                    needleIndex = next[needleIndex - 1];
                } else {
                    haystackIndex++;
                }
            }

            if (needleIndex == needleLength) { // 完全匹配
                return haystackIndex - needleIndex;
            }
        }

        return -1;

    }

    /**
     * 根据给定的pattern返回对应的next数组
     * 
     * @param pattern
     * @return
     */
    static int[] getNext(String pattern) {
        
        int length = pattern.length();
        int[] next = new int[length];
        int left = 0;
        int right = 1;
        while (right < length) {
            if (pattern.charAt(right) == pattern.charAt(left)) { 
                next[right] = left + 1; // left表示的是当前有多少字符匹配
                left++;
                right++;
            } else {
                if (left != 0) {
                    left = next[left - 1];
                } else {
                    next[right] = 0;
                    right++;
                }
            }

        }

        return next;

    }

}
