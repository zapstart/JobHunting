/*#################################### Palindrome Linked List  #########################
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
######################################################################################*/

// #####################################################################
// 思路分析：
// 这道题要求 O(n) 空间, 因此不要用 stack 和 recursive 的方法. 
// 这道题目用到了 reverse linked list.
// 我们首先通过两个不同速度的 node 找到 linked list 的中点, 然后翻转后半
// 部分链表. 翻转后我们通过同时从两边往中间遍历, 如果有不同则返回 false
// 直到遍历到中间节点.
// 
// examples: 
// 1->2->3->1 ---- 1->2<-3<-1 : 2 != 3 返回 false
// 1->2->2->1 ---- 1->2<-2<-1 : 返回 true 
// 1->2->1    ---- 1->2<-1    : 返回 true 
//
// 易错点:
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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode pre, cur, next, head_2;

        if (head == null || head.next == null) return true;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        cur = slow.next;
        pre = slow;
        slow.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        head_2 = pre;
        while (head != null && head_2 != null) {
            if (head.val != head_2.val) return false;
            head = head.next;
            head_2 = head_2.next;
        }
        return true;
    }
}
