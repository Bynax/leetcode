import java.util.ArrayList;
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
        List<String> results = new ArrayList<>();
        if(root==null){
            return results;
        }
        binaryTreePathsRecHelper(root, "", results);
        return results;
        
    }

    /**
     * 递归的辅助方法
     * @param root
     * @param path
     * @param results
     */
    static void binaryTreePathsRecHelper(TreeNode root,String path,List<String>results){
        // leaf
        if(root.left==null&&root.right==null){
            results.add(path+root.val);
        }
        if(root.left!=null){
            binaryTreePathsRecHelper(root.left, path+root.val+"->", results);
        }
        if(root.right!=null){
            binaryTreePathsRecHelper(root.right,path+root.val+"->",results);
        }

    }

}

