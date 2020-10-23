package com.zhentao.review.facebook;

/**
 * 判定一个数组能不能最多只swap数组里面的两个元素就能成为有序数组，如果本来就是已经sorted的话也返回True
 *
 * @author zhentao.li
 *
 */
public class SortableArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6, 7, 5, 8 };
        SortableArray sa = new SortableArray();
        System.out.println(sa.isSortable(nums));

        System.out.println(sa.isSortable(new int[] {1,2,6,4,8,9}));
        System.out.println(sa.isSortable(new int[] {1,2,0,4}));
        System.out.println(sa.isSortable(new int[] {5,4,3,2}));
    }

    public boolean isSortable(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < nums.length-1 && nums[i] <= nums[i+1]) {
            i++;
        }
        if (i == nums.length-1) {
            return true;
        }

        while (j > 0 && nums[j] >= nums[j-1]) {
            j--;
        }
        swap(nums, i, j);
        if (i > 0) {
            i--;
        }
        if (j < nums.length-1) {
            j++;
        }
        while(i < j) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
            i++;
        }
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
