## 堆

## 部分例题

### [23.Merge k Sorted Lists](./23.merge-k-sorted-lists.java)

- 题目描述

- 思路

  其实这道题目不算堆的题目。可能和堆联系是可以用优先队列做？

  这题目的整体思路是Merge sorted list one by one。对左右部分分别进行递归操作，在最后将左右部分合并即可。

###[215.Kth Largest Element in an Array](./215.kth-largest-element-in-an-array.java) 

-  题目描述

- 思路

  - 暴力

    将数组排序然后输出第k大的元素

  - 优先队列

    将数组中的数都add到优先队列中，不断poll直至输出第k大。

  - 快速排序的思想

    随机选取一个元素作为pivot，将大于他的放在左边小于放右边。然后对比当前pivot的index与目标的index，如果大于则说明在右半部分，如果小于说明在左半部分，接着对选出来的部分进行同样的操作。

    


