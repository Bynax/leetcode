import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode id=145 lang=java
 * [145] Binary Tree Postorder Traversal
 */

class Solution {
    public static List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversalUnrec(root);
    }

    /**
     * 使用递归实现二叉树后序遍历
     * @param root
     * @return
     */
    static List<Integer> postorderTraversalRec(TreeNode root){
        List<Integer>results = new ArrayList<>();
        postorderTraversalRecHelper(root, results);
        return results;

    }

    /**
     * 二叉树后续遍历具体实现
     * @param root
     * @param results
     */
    static void postorderTraversalRecHelper(TreeNode root,List<Integer>results){
        if(root==null){
            return;
        }
        postorderTraversalRecHelper(root.left, results);
        postorderTraversalRecHelper(root.right, results);
        results.add(root.val);


    }


    static List<Integer> postorderTraversalUnrec(TreeNode root){
        List<Integer>results = new ArrayList<>();
        if(root==null){
            return results;
        }

        Stack<TreeNode> lrStack = new Stack<>(); // 主要存放左右结点的栈
        Stack<TreeNode>rootStack = new Stack<>(); // 存放被访问但是没有输出的root的栈

        lrStack.push(root);
        while(!lrStack.isEmpty()){
            root = lrStack.pop();
            rootStack.push(root);
            if(root.left!=null){
                lrStack.push(root.left);
            }
            if(root.right!=null){
                lrStack.push(root.right);
            }

        }
        while(!rootStack.isEmpty()){
            results.add(rootStack.pop().val);
        }
        return results;
    }

}

