package com.zhentao.review.dp;

class NumArray {
    private int[] memo;

    public NumArray(int[] nums) {
        int length = nums.length;
        memo = new int[length  +1];
        memo[0] = 0;
        for (int i = 1; i <= length; i++) {
            memo[i] = memo[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return memo[j+1] - memo[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};

        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
