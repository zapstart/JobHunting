/*#################################### Remove Nth Node From End of List #########################
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
###############################################################################################*/

// #####################################################################
// 思路分析：
// 这道题思路就是你用两个相隔 n + 1 的指针遍历 linked list.
// 当处于前面指针为 null 时候, 后面的指针正好处于要删除节点的前一个位置.
//
// 易错点:
// 如何根据 n 来选择循环次数是这类题目容易犯错误的地方.
// 为了删除倒数第 n 个数字, 我们慢指针一定最终要处于其前一个节点.
// ...-> An-1 -> An -> An+1 ... -> null
//       slow                      fasta
// 而快指针这个时候要处于 null (如果用 node != null 来遍历). 
// 所以 slow 和 fast 之间相隔 n + 1, 因此 fast 要前进 n + 1 后 slow 
// 才开始前进.
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
     public ListNode removeNthFromEnd(ListNode head, int n) {
         int i = 0;
         ListNode p1 = new ListNode(0);
         ListNode p2 = p1;
         ListNode new_head;

         new_head = p2;
         p1.next = head;
         for (; p1 != null; ) {
             if (i <= n) {
                 p1 = p1.next;
                 i++;
             }
             else {
                 p1 = p1.next;
                 p2 = p2.next;
             }
         }
         p2.next = p2.next.next;
         return new_head.next;
     }
 }
