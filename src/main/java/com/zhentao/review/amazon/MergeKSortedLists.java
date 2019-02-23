package com.zhentao.review.amazon;

/**
 * <b>23. Merge k Sorted Lists</b>
 *
 * <pre>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 *
 *
 * </pre>
 *
 * @author zhentao
 *
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(final ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        final int length = lists.length;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return lists[0];
        }
        ListNode node = mergeLists(lists[0], lists[1]);
        for (int i = 2; i < length; i++) {
            node = mergeLists(node, lists[i]);
        }
        return node;
    }

    private ListNode mergeLists(final ListNode list1, final ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        final ListNode head = new ListNode(0);//dummy head

        ListNode node = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }

            node = node.next;
        }
        if (head1 != null) {
            node.next = head1;
        } else {
            node.next = head2;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(final int x) {
            val = x;
        }

        @Override
        public boolean equals(final Object other) {
            ListNode that = (ListNode) other;
            ListNode node = this;
            while (that != null && node != null) {
                if (that.val != node.val) {
                    return false;
                }
                that = that.next;
                node = node.next;
            }

            return that == node;
        }

        @Override
        public String toString() {
            return val + " " + (next != null ? next.toString() : "");
        }
    }
}
