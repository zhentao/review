package com.zhentao.review;

public class RemoveDupsFromSortedArray {
    public static void main(String args[]) {
        int a[] = {0, 10, 20, 30, 30, 40, 3000000};
         //a =new int[]{1,1,2,2};
        int output = removeDuplicates(a);
        System.out.println(output);
    }

    public static int removeDuplicates(int[] A) {
        int j = 0;
        if (A.length == 0)
            return 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] != A[j]) {
                j++;
                A[j] = A[i];
            }
        }
        return j + 1;
    }

}
