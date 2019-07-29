/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {
    public static boolean isMatch(String s, String p) {
        return isMatchDp(s, p);
    }

    /**
     * 使用递归的方法实现isMatch
     * 
     * @param s
     * @param p
     * @return
     */
    boolean isMatchRec(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 第一个字符匹配的情况
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        // 第二个字符的情况，要对'*'进行处理，*只可能出现在第二个字符
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
            // 两种情况，一种是*为0，一种是将前一个字符抵消
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     * 使用动态规划的方法实现isMatch
     * 
     * @param s s for string
     * @param p p for pattern
     * @return
     */
    static boolean isMatchDp(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        int sLength = s.length() + 1;
        int pLength = p.length() + 1;
        // s和p各多一个空字符作为初始化
        boolean match[][] = new boolean[pLength][sLength];
        // 初始化
        match[0][0] = true; // 初始化第一个元素，两个空字符匹配
        // 因为空字符匹配s串都是为false，是默认的所以不需要初始化
        // 初始化p，因为p有'*'的出现，所以可能有true
        for (int i = 1; i < pLength; i++) {
            if (p.charAt(i - 1) == '*') {
                match[i][0] = match[i - 2][0];
            }
        }
        // 填数组
        for (int i = 1; i < pLength; i++) {
            for (int j = 1; j < sLength; j++) {
                if (p.charAt(i - 1) == '*') {
                    match[i][j] = match[i - 2][j]
                            || (p.charAt(i - 2) == s.charAt(j - 1) || '.' == p.charAt(i - 2)) && match[i][j - 1];
                    // 当此单元对应的字符是'*'时，两种情况分别对应匹配0的状态和0到any的状态
                } else {
                    match[i][j] = match[i - 1][j - 1] && ('.' == p.charAt(i - 1) || p.charAt(i - 1) == s.charAt(j - 1));
                    // 当此单元对应不是*时，看左上角的状态和当前字符是否匹配两者做与运算的结果
                }
            }
        }

        return match[pLength - 1][sLength - 1];
    }

}
