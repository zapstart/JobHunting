/*#################################### Delete Node in a Linked List  #################################
Write a function to delete a node (except the tail) in a singly linked list, given only
access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
the linked list should become 1 -> 2 -> 4 after calling your function.
####################################################################################################*/

// #####################################################################
// 思路分析：
// 初看这道题无从下手, 但由于其可以修改原始链表, 我们只需要将该节点的
// 值改成其后一个节点的值即可.
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
    public void deleteNode(ListNode node) {

        if (node.next == null) node = null;

        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
