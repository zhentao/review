package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0109 {

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = build(Arrays.asList(-10,-3,0,5,9), 0, nums.length - 1);
        System.out.println(root);
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> nums = toArrayList(head);

        return build(nums, 0, nums.size()-1);
    }

    static TreeNode build(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int mid = start + (end - start)/2;
            TreeNode parent = new TreeNode(nums.get(mid));
            parent.left = build(nums, start, mid - 1);
            parent.right = build(nums, mid+1, end);
            return parent;
        }
    }
    private static ArrayList<Integer> toArrayList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null) {
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
