import java.util.HashMap;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */
class Solution {
    public static String minWindow(String s, String t) {
        return minWindowImp2(s, t);
    }

    /**
     * 使用滑动窗口/双指针+HashMap的方法实现
     * 
     * @param s
     * @param t
     * @return
     */
    static String minWindowImp(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int count = tLength;
        int currentMinLength = Integer.MAX_VALUE;
        int minLeftIndex = 0;
        if (sLength < tLength || sLength == 0 || tLength == 0) {
            return ""; // 边界条件检查
        }

        HashMap<Character, Integer> requiredMap = new HashMap<>();
        int leftPointer = 0; // 左指针，负责控制边界
        int rightPointer = 0; // 右指针，负责expand
        for (int i = 0; i < tLength; i++) {
            requiredMap.put(t.charAt(i), requiredMap.getOrDefault(t.charAt(i), 0) + 1); // 将t每个字符放入map中
        }

        while (rightPointer < sLength) { // 利用右指针expand窗口
            if (requiredMap.containsKey(s.charAt(rightPointer))) { // 如果s当前的字符是t的字符
                if (requiredMap.get(s.charAt(rightPointer)) > 0) { // 可能有冗余的字符，因此只有当大于0的时候进行cout--操作
                    count--;
                }
                requiredMap.put(s.charAt(rightPointer), requiredMap.get(s.charAt(rightPointer)) - 1); // 更新t字符
            }
            if (count == 0) { // 目前窗口都满足，通过leftPointer对窗口进行contract操作
                // while中的两个条件第一个是t不包含的元素，第二个是冗余的元素
                while (!requiredMap.containsKey(s.charAt(leftPointer)) || requiredMap.get(s.charAt(leftPointer)) < 0) {

                    if (requiredMap.containsKey(s.charAt(leftPointer))) { 
                        requiredMap.put(s.charAt(leftPointer), requiredMap.get(s.charAt(leftPointer)) + 1);
                    }
                    leftPointer++; 

                }
                if (currentMinLength > rightPointer - leftPointer + 1) { // 更新
                    currentMinLength = rightPointer - leftPointer + 1;
                    minLeftIndex = leftPointer;
                }

            }
            rightPointer++;
        }

        if (count != 0) {
            return "";
        }
        return s.substring(minLeftIndex, minLeftIndex + currentMinLength);

    }

    /**
     * 将上面方法中的HashMap更换为数组实现
     * 
     * @param s
     * @param t
     * @return
     */
    static String minWindowImp2(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < tLength || sLength == 0 || tLength == 0) {
            return ""; // 边界条件检查
        }
        int leftPointer = 0;
        int rightPointer = 0;
        int minLeftIndex = 0;
        int count = tLength;
        int currentMinLength = Integer.MAX_VALUE;
        int[] required = new int[256];
        for (int i = 0; i < tLength; i++) {
            required[t.charAt(i)]++; // 初始化required数组
        }

        while (rightPointer < sLength) {// expand边界

            if (required[s.charAt(rightPointer)] > 0) {
                count--;
            }
            required[s.charAt(rightPointer)]--;
            while (count == 0) { // 当前窗口符合条件
                if (currentMinLength > (rightPointer - leftPointer + 1)) {
                    currentMinLength = rightPointer - leftPointer + 1;
                    minLeftIndex = leftPointer;
                }
                required[s.charAt(leftPointer)]++; 
                if (required[s.charAt(leftPointer)] > 0) { // 移除了t中的元素
                    count++;
                }
                leftPointer++;
            }
            rightPointer++;
        }

        if (minLeftIndex + currentMinLength > sLength) { // 没找到
            return "";
        }
        return s.substring(minLeftIndex, minLeftIndex + currentMinLength);

    }

    // s = "ADOBECODEBANC"
    // t = "ABC"

    // public static void main(String[] args) {
    //     String s = "a";
    //     String t = "b";
    //     System.out.println(minWindow(s, t));
    // }
}
