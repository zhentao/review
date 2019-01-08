package com.zhentao.review.google;

import java.util.HashMap;

/**
 * <b>900. RLE Iterator</b>
 * 
 * <pre>
 * Write an iterator that iterates through a run-length encoded sequence.

The iterator is initialized by RLEIterator(int[] A), where A is a run-length encoding of some sequence.  More specifically, for all even i, A[i] tells us the number of times that the non-negative integer value A[i+1] is repeated in the sequence.

The iterator supports one function: next(int n), which exhausts the next n elements (n >= 1) and returns the last element exhausted in this way.  If there is no element left to exhaust, next returns -1 instead.

For example, we start with A = [3,8,0,9,2,5], which is a run-length encoding of the sequence [8,8,8,5,5].  This is because the sequence can be read as "three eights, zero nines, two fives".

 

Example 1:

Input: ["RLEIterator","next","next","next","next"], [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
Output: [null,8,8,5,-1]
Explanation: 
RLEIterator is initialized with RLEIterator([3,8,0,9,2,5]).
This maps to the sequence [8,8,8,5,5].
RLEIterator.next is then called 4 times:

.next(2) exhausts 2 terms of the sequence, returning 8.  The remaining sequence is now [8, 5, 5].

.next(1) exhausts 1 term of the sequence, returning 8.  The remaining sequence is now [5, 5].

.next(1) exhausts 1 term of the sequence, returning 5.  The remaining sequence is now [5].

.next(2) exhausts 2 terms, returning -1.  This is because the first term exhausted was 5,
but the second term did not exist.  Since the last term exhausted does not exist, we return -1.

Note:

0 <= A.length <= 1000
A.length is an even integer.
0 <= A[i] <= 10^9
There are at most 1000 calls to RLEIterator.next(int n) per test case.
Each call to RLEIterator.next(int n) will have 1 <= n <= 10^9.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class RLEIterator {
    private int[] array;
    private HashMap<Integer, Long> map;
    private int currentIndex;
    private int currentLeft;
    private int length;

    public RLEIterator(int[] A) {
        array = A;
        length = array.length;
        currentIndex = 0;
        currentLeft = array[currentLeft];
        map = new HashMap<>();
        long total = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            total += array[i];
            map.put(i, total);
        }
    }

    public int next(int n) {
        if (currentIndex >= length) {
            return -1;
        }

        if (currentLeft > n) {
            currentLeft -= n;
            return array[currentIndex + 1];
        } else if (currentLeft == n) {
            int element = array[currentIndex + 1];
            currentIndex += 2;
            while (currentIndex < length && (currentLeft = array[currentIndex]) == 0) {
                currentIndex += 2;
            }

            return element;
        } else {
            long totalLeft = currentIndex + 2 < length ? map.get(currentIndex + 2) + currentLeft : currentLeft;
            if (totalLeft < n) {
                currentIndex = length;
                currentLeft = 0;
                return -1;
            } else if (totalLeft == n) {
                currentIndex = length;
                currentLeft = 0;
                return array[length - 1];
            } else {
                int needed = n - currentLeft;

                for (int i = currentIndex + 2; i < length; i += 2) {
                    needed -= array[i];
                    if (needed <= 0) {
                        currentIndex = i;
                        currentLeft = -needed;
                        break;
                    }
                }
            }
        }

        return array[currentIndex + 1];
    }

    private int used = 0;
    /**
     * from leetcode
     * @param n
     * @return
     */
    public int next2(int n) {

        while (currentIndex < length) {
            int LeftAtCurrent = array[currentIndex] - used;
            if (n > LeftAtCurrent) {
                n -= LeftAtCurrent ;
                used = 0;
                currentIndex += 2;
            } else {
                used += n;
                return array[currentIndex];
            }
        }
        return -1;
    }
}
