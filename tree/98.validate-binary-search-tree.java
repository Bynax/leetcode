/*
 * @lc app=leetcode id=98 lang=java
 * [98] Validate Binary Search Tree
 */

class Solution {
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root,null,null);
    }

    /**
     * 使用递归的方法判断是否为二叉搜索树
     * 
     * @param root
     * @return
     */
    static boolean isValidBSTRec(TreeNode root, Integer lower, Integer upper) {
        // 初始化条件
        if (root == null) {
            return true;
        }

        
        if (lower != null&&lower>=root.val) return false; // 若结点值小于等于lower，直接返回false
        if (upper != null&&upper<=root.val) return false;  // 若结点值大于等于lower，直接返回false
        if (!isValidBSTRec(root.left, lower, root.val)) return false; // 递归过程，将upper设置为root.value因为左子树的上限是root.value
        if(!isValidBSTRec(root.right, root.val, upper)) return false; // 递归过程，lower设置为root.value因为右子树的下限是root.value
        return true; //以上过程都没有返回false，则表明以该结点为根的树是BST
    }

    
}
