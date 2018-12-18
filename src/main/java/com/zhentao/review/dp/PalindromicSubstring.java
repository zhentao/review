package com.zhentao.review.dp;

/**
 * <b>647. Palindromic Substrings</b>
 * <pre>
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Note:

    The input string length won't exceed 1000.
</pre>
 * @author zhentao.li
 *
 */
public class PalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(findBruteForce("abc"));
        System.out.println(memo("abc"));
        System.out.println(findBruteForce("aaabbcxxcbb"));
        System.out.println(memo("aaabbcxxcbb"));
    	
		System.out.println(findBruteForce("aaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(memo("aaaaaaaaaaaaaaaaaaaaaaaa"));

    }
    public static int findBruteForce(String input) {
        int length = input.length();
        int total = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isPalindrom(input, i, j)) {
                    total++;
                }
            }
        }

        return total;
    }

    private static boolean isPalindrom(String input, int start, int end) {

        while (start <= end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start +=1;
            end -=1;
        }
        return true;
    }

    public static int memo(String input) {
    	if (input == null) {
    		return 1;
    	}
    	int length = input.length();
    	
    	if (length == 0) {
    		return 1;
    	}
    	
    	int[][] memo = new int[length][length];
        int total = 0;
        memo[0][0] = 1;
        total++;
        for (int j = 1; j < length; j++) {
        	memo[j][j] = 1;
        	total++;
            for (int i = 0; i < j; i++) {
                if (isPalindromMemo(input, i, j, memo)) {
                    total++;
                    memo[i][j] = 1;
                }
            }
        }

        return total;
    }
    
    private static boolean isPalindromMemo(String input, int start, int end, int[][] memo) {
    	if (input.charAt(start) == input.charAt(end)) {
    		if (end - start == 1 || memo[start+1][end-1] == 1) {
    			return true;
    		}
    	}
    	return false;
    }
}
