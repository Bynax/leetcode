/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {
    public boolean isMatch(String s, String p) {
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
     * @param s s for string
     * @param p p for pattern
     * @return
     */
    boolean isMatchDp(String s,String p){
        if(p.isEmpty()){
            return s.isEmpty();
        }
        int pLength = p.length();
        int sLength = s.length();
        boolean[][] match = new boolean[pLength+1][sLength+1];

        // 初始化

        // 完成match数组
        for(int i=0;i<pLength;i++){
            for (int j=0;j<sLength;j++){
                if(p.charAt(i)==s.charAt(j)){ // p是字符的情况
                    match[i][j] = match[i-1][j-1];
                }
                if(p.charAt(i)=='.'){ // p是'.'的情况
                    match[i][j] = match[i-1][j-1];
                }

                if(p.charAt(i)=='*'){ // p是'*'的情况
                    match[i][j] = match[i-1][j-1];
                }
                
            }
        }



        // 返回结果
        return match[pLength][sLength];

    }

}
