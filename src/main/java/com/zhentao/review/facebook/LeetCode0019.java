package com.zhentao.review.facebook;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

 * @author zhentao.li
 *
 */
public class LeetCode0019 {

    public static void main(String[] args) {
        ListNode tail = new ListNode(2, null);
        ListNode head = new ListNode(1, tail);
        LeetCode0019 lc = new LeetCode0019();
        System.out.println(lc.removeNthFromEnd(head, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode front = dummy;
        ListNode back = dummy;

        for (int i = 0; i <= n; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}