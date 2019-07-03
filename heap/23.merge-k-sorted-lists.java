/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

class Solution23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    /**
     * mergeKLists实现方法
     * @param lists 要合并的有序链表组成的list
     * @param start 要合并的起始结点
     * @param end 要合并的终止结点
     * @return
     */
    static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (lists == null || lists.length == 0) {
            return null; // 初始判空
        }
        if (start >= end) {
            return lists[start]; // 递归终止条件
        }
        int middle = start + (end - start) / 2;
        ListNode leftNode = mergeKListsHelper(lists, start, middle); // 合并左半部分结点
        ListNode rightNode = mergeKListsHelper(lists, middle + 1, end); // 合并右半部分结点
        return merge2Lists(leftNode, rightNode); // 最终合并

    }

    /**
     * 合并两个有序的链表
     * 
     * @param l1
     * @param l2
     * @return 合并后链表的头节点
     */
    static ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }

}
