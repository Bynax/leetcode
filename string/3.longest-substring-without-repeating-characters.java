import java.lang.Math;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringImp(s);
    }

    /**
     * 使用双指针的方法实现
     * 
     * @param s
     * @return
     */
    static int lengthOfLongestSubstringImp(String s) {
        int sLength = s.length();
        if (sLength == 0) { // 边界检测
            return 0;
        }
        int[] indexMap = new int[256];
        int leftPointer = 0; // 左指针
        int rightPointer = 0; // 右指针
        int currentMaxLength = 0; // 当前的最大长度
        while(rightPointer<sLength){
            if(indexMap[s.charAt(rightPointer)]>0){
                // 表示出现过
                leftPointer = Math.max(leftPointer, indexMap[s.charAt(rightPointer)]);
            }
            currentMaxLength = Math.max(currentMaxLength, rightPointer-leftPointer+1); // 更新当前最大长度
            indexMap[s.charAt(rightPointer)] = rightPointer+1; // 更新最近该元素出现的下标
            rightPointer++; // 更新尾结点
        }
        return currentMaxLength;
    }
}
