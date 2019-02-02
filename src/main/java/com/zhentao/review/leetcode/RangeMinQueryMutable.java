package com.zhentao.review.leetcode;

public class RangeMinQueryMutable extends SegmentTree {

    public RangeMinQueryMutable(final int[] nums) {
        super(nums);
    }

    public int findMin(final int i, final int j) {
        return query(root, i, j,Integer.MAX_VALUE);
    }


    @Override
    protected int merge(final int left, final int right) {
        return Math.min(left, right);
    }

    @Override
    protected SegmentTreeNode createNode(final int start, final int end) {
        return new SegmentTreeNode(start, end) {
            @Override
            void merge() {
                this.val = Math.min(left.val, right.val);
            }
        };
    }
}
