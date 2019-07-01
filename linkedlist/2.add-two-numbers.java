/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersImp(l1, l2);
    }

    /**
     * 实现两个链表相加
     * 
     * @param l1
     * @param l2
     * @return
     */
    static ListNode addTwoNumbersImp(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 常见的dummyHead的用法
        int carry = 0; // 用来存储进位
        int x = 0; // 用来存储l1结点的值
        int y = 0; // 用来存储l2结点的值
        ListNode currentNode = dummyHead; //相当于游标

        while (l1 != null || l2 != null) {
            x = l1 == null ? 0 : l1.val; // 为x赋值
            y = l2 == null ? 0 : l2.val; // 为y赋值

            currentNode.next = new ListNode((x + y + carry) % 10); // 当前结点的下一个结点
            carry = (x + y + carry) / 10; // 获取进位

            currentNode = currentNode.next; // 更新游标
            if (l1 != null) {
                l1 = l1.next; // 更新l1

            }
            if (l2 != null) {
                l2 = l2.next; // 更新l2

            }

        }
        if (carry > 0) {
            currentNode.next = new ListNode(carry); // 防止最后有进位的情况
        }
        return dummyHead.next; // 返回结果
    }
}
