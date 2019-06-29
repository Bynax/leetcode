import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode id=94 lang=java
 * [94] Binary Tree Inorder Traversal
 */

class Solution {
    public static List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalUnrec(root);
    }

    /**
     * 使用递归的方法
     * @param root
     * @return
     */
    static List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inorderTraversalHelper(root, results);
        return results;

    }

    /**
     * 中序遍历所需要的辅助函数
     * 
     * @param root    根结点
     * @param results 结果数组
     */
    static void inorderTraversalHelper(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, results); // 递归对左子树进行同样的操作
        results.add(root.val); // 将根结点的值添加到结果链表中
        inorderTraversalHelper(root.right, results); // 递归对右子树进行同样的操作

    }

    /**
     * 
     * @param root
     * @return
     */
    static List<Integer> inorderTraversalUnrec(TreeNode root){

        List<Integer> results = new ArrayList<>();
        if(root==null){
            return results;
        }
        Stack<TreeNode>stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){ //第一个条件是保证遍历到最左，第二个条件是所有元素都遍历完
           if(root!=null){
               stack.push(root); // 当root不为null时候，表示还有左子树
               root = root.left; // 更新root
           }else{
               root = stack.pop(); // 当root为null时候要出栈
               results.add(root.val); // 添加到结果数组中
               root = root.right; // 将root更新为右子树
           }

        }
        return results;
    }


}
