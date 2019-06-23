
/**
 * 测试程序所需要的一些代码
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Util {
    /**
     * 设置无环链表的方法，这里只是示例，可以根据需要修改
     * 
     * @return 无环链表的头节点
     */
    static ListNode def_lists_no_cycle() {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        return head;
    }

    /**
     * 设置带环链表的方法，这里只是示例，根据自己需求修改
     * 
     * @return
     */
    static ListNode def_lists_cycle() {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;
        return head;
    }
}
