/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

class Solution206 {

    public ListNode reverseList(ListNode head) {
        return reverseListIter(head);
    }

    /**
     * 反转链表的递归解法
     * 
     * @param head 头指针
     * @return reversedListHead 反转之后的头指针
     */
    ListNode reverseListRec(ListNode head) {
        // 判断是否符合为空和递归出口
        if (head == null || head.next == null) {
            return head;
        }
        // 反转当前节点之后的链表
        ListNode reversedListHead = reverseListRec(head.next);
        // 将当前节点加到反转后链表的尾部
        head.next.next = head;
        // 当前节点在尾部，因此next要置为null
        head.next = null;
        // 返回reverse之后链表的头部
        return reversedListHead;
    }

    /**
     * 反转链表的迭代解法
     * 
     * @param head 头节点
     * @return head 反转好的头节点
     */
    ListNode reverseListIter(ListNode head) {
        // 判空和单独节点的情况
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null; // 记录上一个节点的位置
        ListNode currentNode = head; // 记录当前节点
        ListNode nextNode;// 下一个节点
        // 循环的过程可以看作是使用头插法将currentNode插到preNode的过程
        while (currentNode != null) {
            nextNode = currentNode.next; // 保留现在的nextNode作为下一次的currentNode
            currentNode.next = preNode; // 反转当前的currentNode
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }
}
