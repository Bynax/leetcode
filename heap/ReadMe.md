## 堆

## 部分例题

### [23.Merge k Sorted Lists](./23.merge-k-sorted-lists.java)

- 题目描述

- 思路

  其实这道题目不算堆的题目。可能和堆联系是可以用优先队列做？

  这题目的整体思路是Merge sorted list one by one。对左右部分分别进行递归操作，在最后将左右部分合并即可。

### [215.Kth Largest Element in an Array](./215.kth-largest-element-in-an-array.java) 

-  题目描述

- 思路

  - 暴力

    将数组排序然后输出第k大的元素

  - 优先队列

    将数组中的数都add到优先队列中，不断poll直至输出第k大。

  - 快速排序的思想

    随机选取一个元素作为pivot，将大于他的放在左边小于放右边。然后对比当前pivot的index与目标的index，如果大于则说明在右半部分，如果小于说明在左半部分，接着对选出来的部分进行同样的操作。

### [218.The Skyline Problem](./218.the-skyline-problem.java)

- 题目描述

- 思路

  sweep line+堆

  [参考解析](https://leetcode.com/problems/the-skyline-problem/discuss/61192/Once-for-all-explanation-with-clean-Java-code(O(n2)time-O(n)-space)

### [239.Sliding Window Maximum](./239.sliding-window-maximum.java)

- 题目描述

  Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

  **Example：**

  ```java
  Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
  Output: [3,3,5,5,6,7] 
  Explanation: 
  
  Window position                Max
  ---------------               -----
  [1  3  -1] -3  5  3  6  7       3
   1 [3  -1  -3] 5  3  6  7       3
   1  3 [-1  -3  5] 3  6  7       5
   1  3  -1 [-3  5  3] 6  7       5
   1  3  -1  -3 [5  3  6] 7       6
   1  3  -1  -3  5 [3  6  7]      7
  ```

- 思路

  首先进行数组的遍历，同时维护一个下标窗口来保存窗口的最大值。总体的思路为：
  将失效元素的下标移除。如遍历到第五个元素，窗口值为3时候，此时最大值只可能出现在3，4，5中，将0，1，2称为失效元素。**因为每次只滑动一个值，因此每次也只有一个元素失效，所以这边用if代替while**
  第二步是判断当前元素与已经遍历元素的关系，若之前的元素比当前元素小，则之前元素没有资格成为当前窗口的最大值，因此将之前元素下标移除。
  判断是否到达一个窗口的极限，若此时到了一个窗口的边界，则将此时的最大值（在队头）存入结果中。

### [295.Find Median from Data Stream](./295.find-median-from-data-stream.java)

- 题目描述

  Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

  For example,

  ```java
  [2,3,4], the median is 3
  [2,3], the median is (2 + 3) / 2 = 2.5
  ```

  Design a data structure that supports the following two operations:

  - void addNum(int num) - Add a integer number from the data stream to the data structure.
  - double findMedian() - Return the median of all elements so far.

  **Example：**

  ```java
  addNum(1)
  addNum(2)
  findMedian() -> 1.5
  addNum(3) 
  findMedian() -> 2
  ```

- 思路

  添加元素时候使用两个堆（一个最大堆一个最小堆）来存储，而且要保证最小堆中存放的是数组中数值大的部分，最大堆存放的是数值小的部分。这样最后求median时候若两个堆个数相等的时候直接将最小堆的堆顶和最大堆的堆顶求均值即可。

  若两个堆个数不相等的时候，则直接返回第一个添加元素的堆的堆顶。

  最后一个问题是当添加元素时候不可以直接添加，当对最大堆添加元素的时候，因为最大堆要添加的是数值小的半部分的元素，因此要将要添加的元素先加入最小堆，然后将最小堆堆顶的元素添加到最大堆中。

  使用boolean类型的变量even表示是否是平衡的，或者相当于一个tag，表示当前要添加元素的堆。

### [347.Top K Frequent Elements](./347.top-k-frequent-elements.java)

- 题目描述

  Given a non-empty array of integers, return the **k** most frequent elements.

  **Example 1:**

  ```Java
  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
  ```

  **Example 2:**

  ```java
  Input: nums = [1], k = 1
  Output: [1]
  ```

- 思路

  - 使用HashMap存储元素与元素的频次

  - 使用LIst的数组，数组的下标表示频次，数组的内容表示出现该频次的元素
  - 从后向前遍历，直至找出出现频次最高的K个元素

### [378 Kth Smallest Element in a Sorted Matrix](./378.kth-smallest-element-in-a-sorted-matrix.java)

- 题目描述

  Given a *n* x *n* matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

  Note that it is the kth smallest element in the sorted order, not the kth distinct element.

  **Example:**

  ```java
  matrix = [
     [ 1,  5,  9],
     [10, 11, 13],
     [12, 13, 15]
  ],
  k = 8,
  
  return 13.
  ```

- [ ] 思路

  - 使用元素的方法代替元素下标来进行二分搜索
  - 寻找小于等于middle的元素个数，若大于k，则将上界减一，若小于k，则将下届减一，重复此过程。

### [703.Kth Largest Element in a Stream](./703.kth-largest-element-in-a-stream.java)

- 题目描述

  Design a class to find the **k**th largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

  Your `KthLargest` class will have a constructor which accepts an integer `k` and an integer array `nums`, which contains initial elements from the stream. For each call to the method `KthLargest.add`, return the element representing the kth largest element in the stream.

  **Example:**

  ```java
  int k = 3;
  int[] arr = [4,5,8,2];
  KthLargest kthLargest = new KthLargest(3, arr);
  kthLargest.add(3);   // returns 4
  kthLargest.add(5);   // returns 5
  kthLargest.add(10);  // returns 5
  kthLargest.add(9);   // returns 8
  kthLargest.add(4);   // returns 8
  ```

- 思路

  维护一个大小为k最大堆，每次添加元素时候将该元素添加到堆中，判断堆的大小是否大于了k，若大于则poll，否则不做处理。最后返回堆顶元素。


