package com.zhentao.review.facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <b>23. Merge k Sorted Lists</b> You are given an array of k linked-lists
 * lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * <pre>
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []


Constraints:

    k == lists.length
    0 <= k <= 10^4
    0 <= lists[i].length <= 500
    -10^4 <= lists[i][j] <= 10^4
    lists[i] is sorted in ascending order.
    The sum of lists[i].length won't exceed 10^4.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0023 {
    public static void main(String[] args) {
        LeetCode0023 lc = new LeetCode0023();
        lc.mergeKLists(new ListNode[0]);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {

                return Integer.compare(o1.val, o2.val);
            }

        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode head = new ListNode(0);
        ListNode n = head;
        while (!queue.isEmpty()) {
            n.next = queue.poll();
            n = n.next;
            ListNode node = n.next;
            if (node != null) {
                queue.add(node);
            }
        }

        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }
}
