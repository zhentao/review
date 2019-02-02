package com.zhentao.review.google;

/**
 * 一个正数数组，问是否存在一个平衡点，平衡点的定义是它左右的子数组之和相等
 * @author zhentao
 *
 */
public class BalancePoint {
    public static void main(final String[] args) {
        int[] array = {1,1,1,1,2,2,2};
        System.out.println(find(array));
        
        array = new int[] {1,1,1,1,1,1,2,2,2};
        System.out.println(find(array));
        array = new int[] {2,2};
        System.out.println(find(array));
    }
    /**
     * This algo works because it is a positive array
     * @param array
     * @return
     */
    public static int find(final int[] array) {
        int left = -1;
        int right = array.length;
        int sumFromLeft = 0;
        int sumFromRight = 0;
        while (left <= right - 2) {
            if (sumFromRight > sumFromLeft) {
                left++;
                sumFromLeft += array[left];
            } else if (sumFromRight < sumFromLeft) {
                right--;
                sumFromRight += array[right];
            } else {
                if (right - left == 2) {
                    return left + 1;
                }
                left++;
                sumFromLeft += array[left];
                right--;
                sumFromRight += array[right];
            }
        }
        //not found
        return -1;
    }
}
