import java.util.List;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

class Solution {

    public static List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePathsRec(root);
    }
    
    /**
     * 使用递归的方法打印二叉树中所有的路径
     * @param root
     * @return
     */
    static List<String> binaryTreePathsRec(TreeNode root){
        
        if(root==null){
            return root;
        }
        

    }
}

