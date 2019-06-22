
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

class Solution3{
    public static ListNode detectCycle(ListNode head) {
        return cycleDetect(head);
    }

    /**
     * 检测链表是否有环
     * 
     * @param head
     * @return isCycle?null:head 若无环返回null，有环返回cycleHead
     */
    static ListNode cycleDetect(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fastNode = head; // 设置快节点
        ListNode slowNode = head; // 设置慢节点
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next; // 更新
            slowNode = slowNode.next; // 更新
            if (fastNode == slowNode) { // 相遇说明有环
                slowNode = head; // 将slowNode或者fastNode置为head
                while (slowNode != fastNode) { // 一个点由head开始一个点由meet开始，寻找再次的交点
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                }
                return slowNode; // 交点即为cycle的开始节点
            }

        }
        return null; // 跳出循环表示无环，返回null

    }
}
