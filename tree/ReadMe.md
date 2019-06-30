## 树

## 基本知识(TODO)

## 部分题目

### [94.Binary Tree Inorder Traversal](./94.binary-tree-inorder-traversal.java)

- 思路

  - 递归（因为基本每本教科书都有三种遍历的递归解法，这里之记录迭代的解法）

  - 迭代

    中序遍历的顺序为“左->中->右”。

    首先从根结点开始不断将左子树压栈，直到没有左子树。

    将栈顶元素弹出添加到结果数组中。

    将根结点改为右结点重复上述操作

### [98. Validate Binary Search Tree](./98.validate-binary-search-tree.java)

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
  

### [102.Binary Tree Level Order Traversal](./102.binary-tree-level-order-traversal.java)

- 思路

  树的一般方法都是使用**队列**来进行层序遍历，关键的点在于如何区分层与层之间。这里采用的是计数的方法。

  首先将root入队，然后开始循环

  每次进行循环的时候首先看此时队列中的元素个数。此时的元素个数也就是本层的结点个数。使用count来标记个数然后进行循环

  在将每个节点出队的时候对其左右子树进行判空操作，若不为空则入队。

  最后在每层循环结束后当结果List存放如最终的结果List中。

  

### [144.Binary Tree Preorder Traversal](./144.binary-tree-preorder-traversal.java)

- 思路

  - 递归

  - 迭代

    将根结点压栈，判断左右结点是否为空，若不为空则也压栈

    **压栈顺序为先右结点再左结点，因为栈的性质是先进后出**

    直到栈中没有元素为止。

### [145.Binary Tree Postorder Traversal](./145.binary-tree-postorder-traversal.java)

- 思路

  - 递归

  - 迭代

    使用两个栈来达到后序遍历的目的。第一个栈的目的是调整顺序，将第一个栈的出栈结果进入到第二个栈中。最终的结果为第二个栈的出栈结果。

    初始化条件是将root入栈，然后开始循环。

    首先将root出栈，将root.left和root.right入栈（判空），接着将root押入到第二个栈中。因为是连续两次入栈出栈，因此要按照left在先，right在后的原则。
    
    重复上述操作直至第一个栈为空。

### [235. Lowest Common Ancestor of a Binary Search Tree](./235.lowest-common-ancestor-of-a-binary-search-tree)

- 思路

  还是BST的性质，如果两个的值都大于root的值，说明在右子树，如果都小于root的值，说明在左子树。如果一大一小，说明LCA就是root。

### [236. Lowest Common Ancestor of a Binary Tree](./236.lowest-common-ancestor-of-a-binary-tree/)

- 思路一：

  将两个结点的路径打印出来，从根结点开始比较。找到最后一个相同的结点返回

- 思路二：后序遍历
  - 因为是后序遍历，因此当处理root结点的时候，此时可以得到以root为根的左右子树的结果，左子树记为left，右子树记为right。
  - 若root为null或者等于其中一个结点，则返回root
  - 若左右子树都为null，则返回null
  - 若都不为null，则返回root
  - 若其中一个为null，直接返回非null的。

### [257.Binary Tree Paths](./257.binary-tree-paths.java)

- 思路

  同二叉树遍历基本相同

