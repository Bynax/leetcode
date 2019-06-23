/*
 * @lc app=leetcode id=25 lang=java
 * [25] Reverse Nodes in k-Group
 */

class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroupIter(head, k);
    }

    /**
     * 使用递归的方法对链表进行k-group reverse
     * 
     * @param head
     * @param k
     * @return 返回结果链表的头结点
     */
    static ListNode reverseKGroupRec(ListNode head, int k) {
        // 初始条件判断
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        // currentNode为了寻找进行reverse的一组结点的尾结点
        ListNode currentNode = head;
        int nodeIndex = 0; //初始化nodeIndex，表示当前结点的下标
        while (currentNode != null) {
            nodeIndex++; 
            if (nodeIndex == k) { //表示够一组，需要进行reverse的操作
                // 保留当前组尾结点的next信息以便进行递归
                ListNode nextStartNode = currentNode.next; 
                // 对当前组进行reverse操作
                reverseLinkedList(head, currentNode);
                // head为当前组的尾结点，将其next设置为递归后链表的头结点
                head.next = reverseKGroupRec(nextStartNode, k);
                return currentNode;

            } else {
                // 更新currentNode
                currentNode = currentNode.next;
            }
        }
        // 返回结果
        return head;

    }

    /**
     * 将给定的链表进行reverse（迭代的方法）
     * 
     * @param head reverse链表的开始结点
     * @param tail revese链表的结束结点
     * @return revese之后链表的开始结点
     */
    static ListNode reverseLinkedList(ListNode head, ListNode tail) {
        // 因为要reverse的是部分链表，头结点的next应该为tail结点的next部分
        // 其他的与普通的reverse链表操作相同
        ListNode preNode = tail.next;
        ListNode currentNode = head;
        ListNode nextNode;
        while (preNode != tail) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;

    }

    /**
     * 使用迭代的方法对链表进行k-group reverse
     * 
     * @param head 原始头结点
     * @param k    group数目
     * @return
     */
    static ListNode reverseKGroupIter(ListNode head, int k) {
        // 初始化操作
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        // 引入一个假的head
        ListNode dummyHead = new ListNode(0);
        // 将dummyHead设置在head的前面
        dummyHead.next = head;
        // 初始化 currentNode，currentNode的作用就是为了寻找进行reverse组的尾部结点
        ListNode currentNode = head;
        // currentNode的下标
        int nodeIndex = 0;
        // 每一个进行reverse组的dummyHead
        ListNode dummyHeadTmp = dummyHead;
        while (currentNode != null) {
            nodeIndex++;
            // %k==0 表示要进行reverse
            if (nodeIndex % k == 0) {
                // 每个组的dummyHead的next要设置为reverse后的head
                dummyHeadTmp.next = reverseLinkedList(head, currentNode);
                // head其实是reverse后的尾结点，因此是下一组的dummyHead
                dummyHeadTmp = head;
                // 更新head
                head = head.next;
                // 更新currentNode
                currentNode = head;

            } else {
                currentNode = currentNode.next;
            }
        }
        return dummyHead.next;
    }

}
