package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>109. Convert Sorted List to Binary Search Tree</b> Given a singly linked
 * list where elements are sorted in ascending order, convert it to a height
 * balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 *
 * <pre>
Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0109 {

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode root = build(Arrays.asList(-10, -3, 0, 5, 9), 0, nums.length - 1);
        System.out.println(root);
    }

    public TreeNode sortedListToBST1(ListNode head) {
        List<Integer> list = toArrayList1(head);

        return build1(list, 0, list.size()-1);
    }

    private List<Integer> toArrayList1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
        }
        return list;
    }
    private TreeNode build1(List<Integer> list, int start, int end) {
        TreeNode root = null;
        if (start<=end) {
            int mid = start + (end - start) / 2;
            root = new TreeNode(list.get(mid));
            root.left = build1(list, start, mid-1);
            root.right = build1(list, mid+1, end);
        }
        return root;
    }




    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> nums = toArrayList(head);

        return build(nums, 0, nums.size() - 1);
    }

    static TreeNode build(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int mid = start + (end - start) / 2;
            TreeNode parent = new TreeNode(nums.get(mid));
            parent.left = build(nums, start, mid - 1);
            parent.right = build(nums, mid + 1, end);
            return parent;
        }
    }

    private static ArrayList<Integer> toArrayList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    static class ListNode {
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
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
