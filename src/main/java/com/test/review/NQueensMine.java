package com.test.review;

import java.util.List;

public class NQueensMine {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solve(10));
        System.out.println(System.currentTimeMillis() - start);
    }
    public static int solve(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        int count = 0;
        List<int[]> list = Permutation.permuteArray(array);
        for (int[] a : list) {
            if (isValid(a)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isValid(int[] input) {
        int length = input.length;
        for (int i = 0; i < length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < length; j++) {
                count++;
                if (input[i] + count == input[j] || input[i] - count == input[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
