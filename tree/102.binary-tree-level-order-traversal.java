import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderImp(root);
    }

    static List<List<Integer>> levelOrderImp(TreeNode root) {
        // LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        List<List<Integer>> results = new LinkedList<List<Integer>>(); // 结果List
        if(root==null){
            return results;
        }
        queue.offer(root); // 将root入队
        while(!queue.isEmpty()){
            List<Integer> levelList = new LinkedList<>(); // 存放每一层的遍历结果
            int levelCount = queue.size(); // 当前层的结点个数
            for(int i=0;i<levelCount;i++){ 
                root = queue.poll(); // 将root出队
                levelList.add(root.val); // 将root存入当前的遍历List中
                if(root.left!=null){
                    queue.offer(root.left); // 若左结点不为空，入队
                }
                if(root.right!=null){
                    queue.offer(root.right); // 若右结点不为空，入队
                }
            }
            results.add(levelList); // 将当前层的遍历结果存放如结果数组中
        }
        return results;
    }
}
