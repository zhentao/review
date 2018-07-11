package com.zhentao.review;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,4,5};
        MissingNumber missing = new MissingNumber();
        System.out.println(missing.findMissing(array));
        System.out.println(missing.findMissingBySort(array));
        System.out.println(missing.findMissingWithArray(array));
    }
    /**
     * @param array an array of unique numbers that are in the range from 1 - N, but one number is missing
     * @return the missing number
     */
    public int findMissing(int[] array) {
        int sum = (1 + array.length + 1) * (array.length + 1) / 2; // The sum of 1 to N
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

    public int findMissingWithArray(int [] array) {
        int[] newArray = new int[array.length + 1];
        for (int a : array) {
            newArray[a - 1] = a;
        }
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
