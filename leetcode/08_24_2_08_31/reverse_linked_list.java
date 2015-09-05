/*#################################### Reverse Linked List  ###########################
Reverse a singly linked list.
#####################################################################################*/

// #####################################################################
// 思路分析：
// 第一种方法是 iteration 方法
// 1) 为了 reverse 链表, 我们至少需要３个 reference 来操作链表, current, 
// previous 和 next
// 2) 首先我们必须保存 next 节点, 这样当 current 节点 reverse 后我们任然
// 能访问 current.next
// 3) 接下来就是将 current 指向, previous 然后将 provious 指向 current, 
// current 指向 next
// 4) 当 current 是 null 时候, previous 就是新的 head了
// 
// 易错点:
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: 
// 空间: 
// #####################################################################

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 方法一: iteration 
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head = pre;

        return head;
    }
}
