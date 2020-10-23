package com.zhentao.review.facebook;

/**
 * <b>148. Sort List</b>
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * <pre>
Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //break the given list to two small lists
        pre.next = null;

        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode l, ListNode r) {
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        if (l.val < r.val) {
            l.next = merge(l.next, r);
            return l;
        } else {
            r.next = merge(l, r.next);
            return r;
        }
    }
    private static class ListNode {
        int val;
        ListNode next;
    }
}
