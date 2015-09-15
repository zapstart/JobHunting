/*#################################### Remove Linked List Elements ###################
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
####################################################################################*/

// #####################################################################
// 思路分析：
// 这道题和 remove array elements 类似, 用两个指针, 只有当前数值不等于
// 要移除的数值时候才将该数字连入新的链表.
// 
// 易错点:
// 对于 head 可能会改变的链表, 我们都需要保存一份头节点.
//
// 难点:
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1) 
// #####################################################################
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy_node = new ListNode(0);
        ListNode new_head = dummy_node;

        if (head == null) return null;
        dummy_node.next = null;

        while (head != null) {
            if (head.val != val) {
                dummy_node.next = head;
                dummy_node = dummy_node.next;
            }
            head = head.next;
        }
        dummy_node.next = null;
        return new_head.next;
    }
}
