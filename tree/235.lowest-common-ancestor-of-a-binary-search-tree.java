/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorIter(root, p, q);

    }

    /**
     * 使用递归寻找BST的LCA
     * @param root
     * @param p
     * @param q
     * @return
     */
    static TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorRec(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorRec(root.left, p, q);
        } else {
            return root;
        }

    }

    /**
     * 使用迭代寻找BST的LCA
     * @param root
     * @param p
     * @param q
     * @return
     */
    static TreeNode lowestCommonAncestorIter(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }

        }
        return null;

    }

}
