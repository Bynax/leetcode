import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=144 lang=java
 * [144] Binary Tree Preorder Traversal
 */

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversalUnRec(root);
    }

    /**
     * 使用递归的方法进行前序遍历
     * 
     * @param root 根结点
     * @return
     */
    static List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorderTraversalHelper(root, results);
        return results;

    }

    /**
     * 先序遍历所需要的辅助函数
     * 
     * @param root    根结点
     * @param results 结果数组
     */
    static void preorderTraversalHelper(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        results.add(root.val); // 将根结点的值添加到结果链表中
        preorderTraversalHelper(root.left, results); // 递归对左子树进行同样的操作
        preorderTraversalHelper(root.right, results); // 递归对右子树进行同样的操作

    }

    /**
     * 使用非递归的方法进行前序遍历
     * 
     * @param root
     * @return
     */
    static List<Integer> preorderTraversalUnRec(TreeNode root) {

        // 顺序不可以颠倒，当root==null时候返回的是空List而不是null
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Stack<TreeNode> stack = new Stack<>(); //初始化栈
        stack.push(root); // 将跟结点押入栈中，开始进行循环
        while (!stack.isEmpty()) {
            root = stack.pop(); // 将栈顶元素出栈
            results.add(root.val); // 将栈顶元素添加到结果list中
            if (root.right != null) { // 先将right押入栈中（判空）
                stack.push(root.right);
            }
            if (root.left != null) { // 将left押入栈中（判空）
                stack.push(root.left);

            }
        }
        return results; // 返回结果
    }
}
