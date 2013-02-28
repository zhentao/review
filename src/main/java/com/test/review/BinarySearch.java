package com.test.review;


public class BinarySearch {
    public int findNoRecursive(int[] input, int target) {

        int left = 0;
        int right = input.length - 1;
        while (left <= right) {
            int m = median(left, right);
            if (input[m] < target) {
                left = m + 1;
            } else if (input[m] > target) {
                right = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    private int median(int left, int right) {
        return (left + right) >>> 1;
    }

    public int find(int[] input, int target) {

        return find(input, 0, input.length - 1, target);
    }

    private int find(int[] input, int left, int right, int target) {
        if (left > right)
            return -1;
        int m = median(left, right);
        if (input[m] == target) {
            return m;
        } else if (input[m] < target) {
            left = m + 1;

        } else {
            right = m - 1;
        }
        return find(input, left, right, target);
    }

    public int findFirst(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            int m = median(left, right);
            if (input[m] < target) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        if (right >= input.length || input[right] != target) {
            return -1;
        }
        return right;
    }
}
