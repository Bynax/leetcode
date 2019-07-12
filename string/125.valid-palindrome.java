/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */
class Solution {
    public static boolean isPalindrome(String s) {
        return isPalindromeImp(s);
    }

    /**
     * 利用双指针法判断一个字符串是否为回文串
     * @param s
     * @return
     */
    static boolean isPalindromeImp(String s){
        if(s==null||s.isEmpty()){ // 边界判断
            return true;
        }
        char[] s2Array = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(!Character.isLetterOrDigit(s2Array[start])){ // 判断是否是有效字符
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(s2Array[end])){ // 判断是否是有效字符
                end--;
                continue;
            }
            if(Character.toLowerCase(s2Array[start])!=Character.toLowerCase(s2Array[end])){ // 比较有效字符
                return false;
            }
            start++; // 更新
            end--; // 更新
        }
        return true;

    }
}

