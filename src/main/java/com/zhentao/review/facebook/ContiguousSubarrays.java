package com.zhentao.review.facebook;

import java.util.Arrays;
import java.util.Stack;

/**
 * You are given an array arr of N integers. For each index i, you are required
 * to determine the number of contiguous subarrays that fulfills the following
 * conditions: The value at index i must be the maximum element in the
 * contiguous subarrays, and These contiguous subarrays must either start from
 * or end on index i.
 *
 * <pre>
 * Signature int[] countSubarrays(int[] arr)
 * Input Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * Size N is between 1 and 1,000,000 Output An array where each index i contains
 * an integer denoting the maximum number of contiguous subarrays of arr[i]
 *
Example:
arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]
Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class ContiguousSubarrays {
    public static void main(String[] args) {
        ContiguousSubarrays cs = new ContiguousSubarrays();
        System.out.println(Arrays.toString(cs.countSubarrays2(new int[] { 3, 4, 1, 6, 2 })));
    }

    public int[] countSubarrays(int[] arr) {
        int length = arr.length;
        int[] results = new int[length];
        for (int i = 0; i < length; i++) {
            results[i] = 1;
        }
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                } else {
                    count = 0;
                }
            }
            results[i] += count;
        }

        for (int i = length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = length - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    count++;
                } else {
                    count = 0;
                }
            }
            results[i] += count;
        }
        return results;
    }

    int[] countSubarrays2(int[] arr) {
        // Write your code here
        Stack<Integer> s = new Stack<>();
        int[] L = new int[arr.length];
        L[0] = 1;
        s.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                L[i] = i + 1;
            else
                L[i] = i - s.peek();
            s.push(i);
        }
        int[] R = new int[arr.length];
        R[arr.length - 1] = L[arr.length - 1];
        s.clear();
        s.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i])
                s.pop();
            if (s.isEmpty())
                R[i] = (arr.length - i) + L[i] - 1;
            else
                R[i] = (s.peek() - i) + L[i] - 1;
            s.push(i);
        }
        return R;
    }
}
