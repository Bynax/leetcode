/*
 * @lc app=leetcode id=236 lang=java
 * [236] Lowest Common Ancestor of a Binary Tree
 */

class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }

    static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = LCA(root.left, p, q); // 遍历左子树
        TreeNode right = LCA(root.right, p, q); // 遍历右子树
        if (left != null && right != null) {
            return root; // 若都不为空，返回根结点
        }
        return left != null ? left : right; 
    }
}
