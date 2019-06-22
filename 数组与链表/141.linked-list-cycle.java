/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static boolean hasCycle(ListNode head) {
        return hasCycleFastAndLow(head);
    }

    /**
     * 使用快慢节点的方式判断一个链表是否有环
     * @param head
     * @return 是否有环的boolean值
     */
    static boolean hasCycleFastAndLow(ListNode head){
        // 空表或只有一个节点肯定没有环
        if(head==null|| head.next==null){
            return false;
        }
        ListNode fastNode = head.next; //设置快节点
        ListNode slowNode = head; //设置慢节点
        while(fastNode!=slowNode){
            // 若没有环，快节点肯定比慢节点先到末尾，只需要判断他们为null就可以
            if(fastNode==null||fastNode.next==null){
                return false; // 
            }
            fastNode = fastNode.next.next; //更新
            slowNode = slowNode.next; //更新
        }
        return true; // 跳出循环表示追上了，也就是有环
    }
}

