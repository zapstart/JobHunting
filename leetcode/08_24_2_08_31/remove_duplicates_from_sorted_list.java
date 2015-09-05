/*#################################### Remove Duplicates from Sorted List  ###############
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
########################################################################################*/

// #####################################################################
// 思路分析：
// 遍历链表, 跳过相同的数字. 注意 if 条件语句的判断
//
// 易错点:
// 无
//
// 难点:
// 无
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode c_node = head;

        while (c_node != null) {
            if (c_node.next == null) {
                break;
            }

            if (c_node.val == c_node.next.val) {
                c_node.next = c_node.next.next;
            }
            else {
                c_node = c_node.next;
            }
        }

        return head;
    }
}
