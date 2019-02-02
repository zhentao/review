package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个数据结构支持插入一系列interval [1,5], [6,10], [3, 4] .... 
 * 和查询某一个整数是否存在于某个 interval
 * 
 * @author zhentao
 *
 */
public class IntervalTreeBST {
    private IntervalTreeNode root;

    public void insert(final Interval interval) {
        root = insert(root, interval);
    }

    /**
     * Based on binary search tree for simplification
     * 
     * @param node
     * @param interval
     * @return
     */
    private IntervalTreeNode insert(final IntervalTreeNode node, final Interval interval) {
        if (node == null) {
            return new IntervalTreeNode(interval);
        } else {
            // If node's low value is smaller, then new interval goes to
            // left subtree
            if (interval.low < node.interval.low) {
                node.left = insert(node.left, interval);
            }

            // Else, new node goes to right subtree.
            else {
                node.right = insert(node.right, interval);
            }

            // Update the max value of this ancestor if needed
            if (node.max < interval.high) {
                node.max = interval.high;
            }
            return node;
        }
    }

    /**
     * find the intervals that contain this point
     * 
     * @param point
     * @return a list of intervals
     */
    public List<Interval> search(final int point) {
        final ArrayList<Interval> list = new ArrayList<>();
        search(root, point, list);
        return list;
    }

    /**
     * Inorder traversal
     * 
     * @param node
     * @param point
     * @param result
     */
    private void search(final IntervalTreeNode node, final int point, final List<Interval> result) {
        if (node == null)
            return;
        // If p is to the right of the rightmost point of any interval in this node and
        // all children, there won't be any matches.
        if (point > node.max) {
            return;
        }
        // Search left children
        if (node.left != null) {
            search(node.left, point, result);
        }
        // Check this node
        if (node.interval.contains(point)) {
            result.add(node.interval);
        }
        // If p is to the left of the start of this interval, it can't be in any child
        // to the right.
        if (point < node.interval.low) {
            return;
        }
        // Otherwise, search right children
        if (node.right != null) {
            search(node.right, point, result);
        }
    }

    public List<Interval> overlapSearchAll(final Interval interval) {
        final ArrayList<Interval> list = new ArrayList<>();
        overlapSearchAll(root, interval, list);
        return list;
    }

    /**
     * Inorder DFS
     * 
     * @param node
     * @param interval
     * @param result
     */
    private void overlapSearchAll(final IntervalTreeNode node, final Interval interval, final List<Interval> result) {
        if (node == null)
            return;
        // If p is to the right of the rightmost point of any interval in this node and
        // all children, there won't be any matches.
        if (interval.low > node.max) {
            return;
        }
        // Search left children
        if (node.left != null) {
            overlapSearchAll(node.left, interval, result);
        }
        // Check this node
        if (node.interval.isOverlap(interval)) {
            result.add(node.interval);
        }
        // If p is to the left of the start of this interval, it can't be in any child
        // to the right.
        if (interval.high < node.interval.low) {
            return;
        }
        // Otherwise, search right children
        if (node.right != null) {
            overlapSearchAll(node.right, interval, result);
        }
    }

    public Interval overlapSearch(final Interval interval) {
        return overlapSearch(root, interval);
    }

    /**
     * This is DFS: only return 1 interval
     * 
     * @param node
     * @param interval
     * @return
     */
    private Interval overlapSearch(final IntervalTreeNode node, final Interval interval) {
        // Base Case, tree is empty or the given interval is not overlapped with any
        // intervals
        if (node == null || interval.low > node.max)
            return null;

        // If given interval overlaps with root
        if (node.interval.isOverlap(interval))
            return node.interval;

        // If left child of root is present and max of left child is
        // greater than or equal to given interval, then given interval may
        // overlap with an interval is left subtree
        if (node.left != null && interval.low <= node.left.max)
            return overlapSearch(node.left, interval);

        // Else interval can only overlap with right subtree
        return overlapSearch(node.right, interval);
    }

    static class Interval {
        int low;
        int high;

        public Interval(final int low, final int high) {
            this.low = low;
            this.high = high;
        }

        boolean isOverlap(final Interval other) {
            return low <= other.high && other.low <= high;
        }

        boolean contains(final int point) {
            return point >= low && point <= high;
        }

        @Override
        public boolean equals(final Object other) {
            final Interval that = (Interval) other;
            return low == that.low && high == that.high;
        }

        @Override
        public String toString() {
            return "low=" + low + " high=" + high;
        }
    }

    static class IntervalTreeNode {
        Interval interval;
        int max;
        IntervalTreeNode right;
        IntervalTreeNode left;

        public IntervalTreeNode(final Interval interval) {
            this.interval = interval;
            this.max = interval.high;
        }

        @Override
        public String toString() {
            return interval + " max=" + max;
        }
    }
}
