/*#################################### Merge Two Sorted Lists #########################
Merge two sorted linked lists and return it as a new list. The new list should be made
by splicing together the nodes of the first two lists.
#####################################################################################*/

// #####################################################################
// 思路分析：
// 这道题和 merge two sorted array 差不多, 只不过这个是 linked list
// 我们首先创建一个 dummy node 来指向合并后链表的头节点, 然后依次插入
// 相应节点.
//
// 易错点:
//
// 难点:
//
// 复杂度分析:
// 时间: O(m + n)
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
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

         ListNode head = new ListNode(0);
         ListNode current = head;

         while (l1 != null && l2 != null) {
             if (l1.val >= l2.val) {
                 current.next = l2;
                 l2 = l2.next;
             }
             else {
                 current.next = l1;
                 l1 = l1.next;
             }
             current = current.next;
         }

         if (l1 != null) {
           current.next = l1;
         }

         if (l2 != null) {
             current.next = l2;
         }

         return head.next;
     }
 }
