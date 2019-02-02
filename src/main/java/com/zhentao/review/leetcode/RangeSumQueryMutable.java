package com.zhentao.review.leetcode;

/**
 * <b>307. Range Sum Query - Mutable</b>
 * 
 * <pre>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class RangeSumQueryMutable extends SegmentTree {
    public RangeSumQueryMutable(final int[] nums) {
        super(nums);
    }

    @Override
    protected SegmentTreeNode createNode(final int start, final int end) {
        return new SegmentTreeNode(start, end) {
            @Override
            void merge() {
                this.val = left.val + right.val;
            }
        };
    }

    @Override
    public void update(final int i, final int val) {
        super.update(i, val);
    }

    public int sumRange(final int i, final int j) {
        return query(root, i, j, 0);
    }

    /**
     * 
     * @param left
     * @param right
     * @return
     */
    @Override
    protected int merge(final int left, final int right) {
        return left + right;
    }
}
