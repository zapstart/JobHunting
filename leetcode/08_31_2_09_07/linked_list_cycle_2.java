/*#################################### Linked List Cycle 2 ###########################
Given a linked list, return the node where the cycle begins. If there is no cycle,
return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
####################################################################################*/

// ###########################################################################
// 思路分析：
// 首先这道题和 linked list cycle 1 一样要使用快慢两个指针. 如果有环, 快慢指针
// 一定会在环上相遇. 我们假设环前长度为 A, 相遇点到入环处相距 B, 环周长 R.
// 则相遇时候, 对于慢指针来说, 其走过 l1 = A + n * R + B, 快指针走过
// l2 = A + m * R + B = 2l1 = 2A + 2n * R + 2B => m * R = A + B + 2n * R =>
// A + B 肯定等于 R 的整数倍 : A + B = x * R
// 因此 A = x * R - B 我们把相遇后的慢指针放回远点, 然后快慢指针以相同速度
// 移动, 则当慢指针抵达进入环位置时候, 快指针在环中走了 x * R - B 的路程. 这时
// 快指针也刚好来到进入环的位置. 所以当快慢指针指向同一结点时, 这个结点就是我们
// 要求的环开始的结点.
//
// 这两个博客对这类问题有总结:
// http://www.cnblogs.com/hiddenfox/p/3408931.html
// http://www.cnblogs.com/wuyuegb2312/p/3183214.html
//
// 易错点:
//
// 难点:
//
// 复杂度分析:
// 时间:
// 空间:
// ###########################################################################
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
     public ListNode detectCycle(ListNode head) {
         ListNode slow = head, fast = head;
         ListNode temp = null;

         if (head == null || head.next == null) return null;

         while (slow != null && fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) {
                 slow = head;
                 break;
             }
         }

         if (slow == null || fast == null || fast.next == null) return null;

         while (slow != fast) {
             slow = slow.next;
             fast = fast.next;
         }
         return slow;
     }
 }
