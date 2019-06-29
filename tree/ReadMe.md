## 树

## 基本知识

- ### 




## 部分题目

### [98. Validate Binary Search Tree](./tree/98.validate-binary-search-tree.java)

- 思路

  - 递归

    刚开始想到的递归过程是：

    - 使用递归判断左右子树是否是BST
    - 若左右子树都是BST再判断root的左右结点是否符合BST的规范
    - 三者是与的关系

    但是这个方法是有一个缺点是不能正确判断类似（5，4，6，null，null，3，2）类似的树。因为这种结构左子树和右子树都是BST，且跟结点也符合。因此在递归时候需要携带上下界的消息。在递归时，对于左子树，将root.val作为upper。对于右子树，将root.val作为lower。因此设计的递归方法参数为isBstRec(root,lower,upper).

  - 树的遍历

    根据BST的性质，若使用中序遍历的话，则BST是一个严格递增的序列，因此将此BST进行中序遍历。

    - 使用中序遍历此BST
    - 中序遍历输出时，用此结点与lower相比较，lower初始化为long.min_value。若当前结点的value小于等于lower，直接返回false。
    - 更新lower为current.value
    - 当树遍历完成后，若没有返回，则说明树是BST，此时返回True





### [235. Lowest Common Ancestor of a Binary Search Tree](./tree/235.lowest-common-ancestor-of-a-binary-search-tree)

- 思路

  还是BST的性质，如果两个的值都大于root的值，说明在右子树，如果都小于root的值，说明在左子树。如果一大一小，说明LCA就是root。

### [236. Lowest Common Ancestor of a Binary Tree](./tree/236.lowest-common-ancestor-of-a-binary-tree/)

- 思路

