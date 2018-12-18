package com.zhentao.review.dp;

/**
 * <b>338. Counting Bits</b>
 *
 * <pre>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]

Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can
    you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount
    in c++ or in any other language.
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class CountBits {
    public static void main(String[] args) {
        int n = 100;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " : " + (findBitsDp(n)[i] == findBits(n)[i]));
            //System.out.println(i % 2 == (i &1));
        }
    }

    private static int[] findBits(int n) {
        int[] count = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            int bits = 0;
            for (int i = 0; i < 32; i++) {
                if ((j & (1 << i)) != 0) {
                    bits++;
                }
            }
            count[j] = bits;
        }

        return count;
    }

    static int[] findBitsDp(int n) {
        int[] count = new int[n+1];
        if (n == 0) {
            return count;
        }
        count[1] = 1;

        int power = 2;
        int newStart = power;
        while(power <= n) {
            for (int i = power/2; i < power && newStart <= n; i++) {
                count[newStart] = count[i];
                newStart++;
            }
            power *= 2;
            while(newStart < power && newStart <= n ) {
                int bits = 0;
                for (int i = 0; i < 32; i++) {
                    if ((newStart & (1 << i)) != 0) {
                        bits++;
                    }
                }
                count[newStart] = bits;
                newStart++;
            }
            newStart = power;
        }

        return count;
    }

    /**
     * f[i] = f[i / 2] + i % 2
     *  (i % 2) == (i & 1)
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
