package com.zhentao.review.leetcode;

public abstract class SegmentTree {
    protected final SegmentTreeNode root;

    public SegmentTree(final int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    protected final SegmentTreeNode buildSegmentTree(final int[] nums, final int start, final int end) {
        if (start > end) {
            return null;
        }
        final SegmentTreeNode node = createNode(start, end);
        if (start == end) {//for leaves
            node.val = nums[start];
        } else {
            final int mid = start + (end - start) / 2;
            node.left = buildSegmentTree(nums, start, mid);
            node.right = buildSegmentTree(nums, mid + 1, end);
            node.merge();
        }
        return node;
    }

    public void update(final int i, final int val) {
        if (root == null) {
            return;
        }
        update(root, i, val);
    }

    protected final void update(final SegmentTreeNode node, final int i, final int val) {
        if (node.start == node.end) {
            node.val = val;
        } else {
            final int mid = node.start + (node.end - node.start) / 2;
            if (i > mid) {
                update(node.right, i, val);
            } else {
                update(node.left, i, val);
            }
            node.merge();
        }
    }

    protected int query(final SegmentTreeNode node, final int i, final int j, final int defaultValue) {
        if (node == null) {
            return defaultValue;
        }
        if (i <= node.start && j >= node.end) {
            return node.val; // [i,j] in the range completely
        }
        // final int mid = node.start + (node.end - node.start) / 2;
        final int left = query(node.left, i, j, defaultValue);
        final int right = query(node.right, i, j, defaultValue);
        return merge(left, right);
    }

    protected abstract int merge(final int left, final int right);

    protected abstract SegmentTreeNode createNode(int start, int end);
}

abstract class SegmentTreeNode {
    int start;
    int end; // the range
    SegmentTreeNode left;
    SegmentTreeNode right;
    int val;

    SegmentTreeNode(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "val=" + val + " left=" + (left == null ? null : left.val)
                + " right=" + (right == null ? null : right.val);
    }
    /**
     * implement here on how to calculate the val
     */
    abstract void merge();
}
