/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// 测试代码
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//     }
// }

class Solution1 {
    public static ListNode swapPairs(ListNode head) {
        return swap(head);
    }


    /**
     * 链表的swap pair
     * @param head
     * @return dummyHead.next 结果链表的头部
     */
    static ListNode swap(ListNode head){
        // 判断空表和长度为1的表
        if(head==null||head.next==null){
            return head;
        }

        ListNode dummyHead = new ListNode(0); // 设置一个head前的节点
        dummyHead.next = head;
        ListNode currentNode = dummyHead; // currentNode 设置为dummyHead
        ListNode firstNode; // 每个dummyHead后面都跟两个节点 firstNode和secondNode对应一个pair
        ListNode secondNode; 
        while(currentNode.next!=null){
            firstNode = currentNode.next; // firstNode 设置为currentNode后的节点
            secondNode = currentNode.next.next; // secondNode设置为currentNode后两个节点
            if(secondNode == null) break; // 当第二个节点是null的时候不能构成一个pair，跳出循环

            // 交换三个节点的指针
            currentNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            currentNode = firstNode;

        }
        return dummyHead.next; // 因为dummyHead是设置的，返回它的next即head
    }
    


    // 测试代码
    // public static void main(String[] args) {
    //     ListNode head = new ListNode(1);
    //     ListNode two = new ListNode(2);
    //     ListNode three = new ListNode(3);
    //     ListNode four = new ListNode(4);
    //     ListNode five = new ListNode(5);
    //     head.next = two;
    //     two.next = three;
    //     three.next = four;
    //     four.next = five;
    //     five.next = null;
    //     ListNode result = swapPairs(head);
    //     while (result != null) {
    //         System.out.println(result.val);
    //         result = result.next;
    //     }

    // }
}
        
        
    

