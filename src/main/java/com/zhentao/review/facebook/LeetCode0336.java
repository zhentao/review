package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>336. Palindrome Pairs</b> Given a list of unique words, return all the
 * pairs of the distinct indices (i, j) in the given list, so that the
 * concatenation of the two words words[i] + words[j] is a palindrome.
 *
 * <pre>
Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]

Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]


Constraints:

    1 <= words.length <= 5000
    0 <= words[i] <= 300
    words[i] consists of lower-case English letters.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0336 {
    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        LeetCode0336 lc = new LeetCode0336();
        System.out.println(lc.palindromePairs(words));
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            for (int i = 0; i <= word.length(); i++) {
                String left = word.substring(0, i);
                String right = word.substring(i);
                //left.length != 0 to remove dups
                if (isPalindrome(left) && left.length() != 0) {
                    String reverseRight = new StringBuilder(right).reverse().toString();
                    Integer index = map.get(reverseRight);
                    if (index != null && index.intValue() != j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(index);
                        list.add(j);
                        result.add(list);

                    }
                }
                if (isPalindrome(right)) {
                    String reverseLeft = new StringBuilder(left).reverse().toString();
                    Integer index = map.get(reverseLeft);
                    if (index != null && index.intValue() != j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        list.add(index);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length()-1;
        while(i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
