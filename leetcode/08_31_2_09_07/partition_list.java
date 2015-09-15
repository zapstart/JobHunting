/*#################################### Partition List ################################
Given a linked list and a value x, partition it such that all nodes less than x come
before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
####################################################################################*/

// #####################################################################
// 思路分析：
// 这道题目用两个指针解决问题. 首先遍历链表, 如果元素值小于要比较的数字,
// 则将这个元素连接到 p1 上, 否则连接到 p2 上. 最后再将 p1 与 p2 链表连接
// 起来. 
// 由于链表的 head 可能会改变, 我们需要保存新的链表头.
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
    public ListNode partition(ListNode head, int x) {
        ListNode temp_1, temp_2;
        ListNode p1 = new ListNode(-1);
        ListNode p2 = new ListNode(-1);
        temp_1 = p1;
        temp_2 = p2;

        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            }
            else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = temp_2.next;
        return temp_1.next;
    }
}
