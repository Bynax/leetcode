import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
class Solution {
    public static List<String> generateParenthesis(int n) {
        return generateParenthesisImp(n);
    }

    /**
     * 使用回溯的方法
     * 
     * @param n
     * @return
     */
    static List<String> generateParenthesisImp(int n) {
        List<String> results = new LinkedList<String>();
        generateParenthesisRec(n, n, "", results);
        return results;
    }

    /**
     * 回溯法具体的递归实现方法
     * 
     * @param leftNeeded
     * @param rightNeeded
     * @param parentString
     * @param results
     */
    static void generateParenthesisRec(int leftNeeded, int rightNeeded, String parentString, List<String> results) {
        if (leftNeeded == 0 && rightNeeded == 0) { // 退出递归的条件
            results.add(parentString); // 表明是一种组合
            return;
        }
        if (leftNeeded > 0) { // 添加左括号的限制条件是当leftNeeded>0
            generateParenthesisRec(leftNeeded - 1, rightNeeded, parentString + "(", results);

        }
        if (leftNeeded < rightNeeded) { // 添加右括号的限制条件是当左括号的个数大于右括号时
            generateParenthesisRec(leftNeeded, rightNeeded - 1, parentString + ")", results);
        }

    }
}
