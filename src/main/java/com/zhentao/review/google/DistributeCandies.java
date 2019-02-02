package com.zhentao.review.google;

import java.util.HashSet;

/**
 * <b>575. Distribute Candies</b>
 * 
 * <pre>
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
The sister has two different kinds of candies, the brother has only one kind of candies. 
Note:

The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].
 * </pre>
 * 
 * @author zhentao
 *
 */
public class DistributeCandies {
    public int distributeCandies(final int[] candies) {
        final HashSet<Integer> set = new HashSet<>(10000);
        for (final int candy : candies) {
            set.add(candy);
        }
        int half = candies.length/2;
        int size = set.size();
        return size >= half ? half : size;
    }
}
