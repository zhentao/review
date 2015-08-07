package com.zhentao.review;

import java.util.Arrays;

public class MissingNumber {

    public void main(String[] args) {
        int[] array = new int[] {1,2,3 };
        MissingNumber missing = new MissingNumber();
        missing.findMissing(array);
        missing.findMissingBySort(array);
    }
    /**
     * @param array an array of unique numbers that are in the range from 1 - 100, but one number is missing
     * @return the missing number
     */
    public int findMissing(int[] array) {
        int sum = (1 + 100) * 100 / 2; // The sum of 1 to 100
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return sum - total;
    }

    /**
     * @param array an array of unique numbers that are in the range from 1 - 100, but one number is missing
     * @return the missing number
     */
    public int findMissingBySort(int[] array) {
        Arrays.sort(array); //This sort method is provided by JDK
        for (int i = 0; i < array.length; i++) {
            if (i + 1 != array[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
