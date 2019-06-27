
/**
 * 测试程序所需要的一些代码
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Util {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(10);
        TreeNode two = new TreeNode(5);
        TreeNode three = new TreeNode(15);
        TreeNode four = new TreeNode(6);
        TreeNode five = new TreeNode(20);
    
        one.left = two;
        one.right = three;
        two.left = null;
        two.right = null;
        three.left = four;
        three.right = five;
    
        System.out.println(isValidBST(one));
        }
    

}
