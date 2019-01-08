package com.zhentao.review.google;

/**
 * <b>86. Partition List</b>
 * 
 * <pre>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 * </pre>
 * 
 * @author zhentao
 *
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        print(partition(head, 3));
        
        n6 = new ListNode(2);
        n5 = new ListNode(3);
        n5.next = n6;
        print(n5);
        print(partition(n5, 4));
        
        n5 = new ListNode(3);
        print(partition(n5, 4));
        
        
        n6 = new ListNode(1);
        n5 = new ListNode(2);
        n5.next = n6;
        print(n5);
        print(partition(n5, 0));
        
        n4 = new ListNode(2);
        n5 = new ListNode(1);
        n6 = new ListNode(3);
        n4.next = n5;
        n5.next = n6;
        print(n4);
        print(partition(n4, 2));
        
        print(partition(null, 2));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(Integer.MIN_VALUE);
        ListNode largeHead = new ListNode(Integer.MIN_VALUE);
        ListNode small = smallHead;
        ListNode large = largeHead;
        while(head != null) {
            ListNode node = new ListNode(head.val); 
            if (head.val < x) {
                small.next = node;
                small = node;
            } else {
                large.next = node;
                large = node;
            }
            head = head.next;
        }
        small.next = largeHead.next;
        return smallHead.next;
    }

    private static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}