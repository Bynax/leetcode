/*
 * @lc app=leetcode id=98 lang=java
 * [98] Validate Binary Search Tree
 */

class Solution {

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTTravel(root, Long.MIN_VALUE);
    }

    /**
     * 使用递归的方法判断是否为二叉搜索树
     * 
     * @param root
     * @return
     */
    static boolean isValidBSTRec(TreeNode root, long lower, long upper) {
        // 初始化条件
        if (root == null) {
            return true;
        }
        if (root.val <= lower || upper <= root.val) {
            return false;
        }
        if (!isValidBSTRec(root.left, lower, root.val))
            return false; // 递归过程，将upper设置为root.value因为左子树的上限是root.value
        if (!isValidBSTRec(root.right, root.val, upper))
            return false; // 递归过程，lower设置为root.value因为右子树的下限是root.value
        return true; // 以上过程都没有返回false，则表明以该结点为根的树是BST
    }

    /**
     * 使用中序遍历的方法去验证是否为有效的二叉树
     * 
     * @param root  根结点
     * @param lower 当前结点可以取的最大值
     * @return 是否为有效二叉树
     */
    static boolean isValidBSTTravel(TreeNode root, long lower) {
        // 初始条件
        if (root == null) {
            return true;
        }

        // 初始化栈
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        // 中序遍历
        while (curr != null || s.size() > 0) {

            // 遍历到最左结点
            while (curr != null) {
                // 将所有的左子树结点放入栈中
                s.push(curr);
                curr = curr.left;
            }

            // 此时的结点为null，因此要对s进行pop()
            curr = s.pop();

            /**
             * 每次输出的结点同lower相比，若小于lower的话直接返回false。
             */
            if (curr.val <= lower)
                return false;
            // 更新lower
            lower = curr.val;

            /*
             * 进行右子树的遍历
             */
            curr = curr.right;

        }
        // 树遍历结束后还没有return的话表明是一个有效的BST
        return true;

    }

}
