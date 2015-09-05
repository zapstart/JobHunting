/*#################################### Linked List Cycle  ############################
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
####################################################################################*/

// #####################################################################
// 思路分析：
// 使用快慢指针来找时候有环, 如果有环则这两个指针一定相遇
// 要考虑无节点, 一个节点, 以及没有环情况
//
// 易错点:
// 无
//
// 难点:
// 无
//
// 复杂度分析:
// 时间: 
// 空间: O(1)
// #####################################################################

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
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;

        slow = head;
        fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
