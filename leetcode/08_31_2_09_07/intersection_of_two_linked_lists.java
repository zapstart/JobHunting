/*#################################### Intersection of Two Linked Lists #####################
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

###########################################################################################*/

// #####################################################################
// 思路分析：
// 解法很巧妙的方法.
// 我们假设三段链表长度分别是 A, B, C(C 是重叠的那一段). 
// 从 A 开始先走 A + C, 然后从 B 开始走, 当其走到重合位置时总共走了
// A + B + C. 这同从 B 开始走的节点同时到重合位置 (B + C + A).因此
// 这个相遇的点就是重合点.(该方法不能求没有交点的 A 和 B 链表) 
//
// 而一般方法解答这个问题应求出两段 linked list 长度, 然后让长的一段
// 先走 B - A (假设 B 大于 A), 然后 A 和 B 端同时走, 直到相遇.
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
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        if (headA == null || headB == null) return null;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;

            if (p1 == p2) {
                return p1;
            }

            if (p1 == null) {
                p1 = headB;
            }
            if (p2 == null) {
                p2 = headA;
            }
        }
        
        return p1;
    }
}
