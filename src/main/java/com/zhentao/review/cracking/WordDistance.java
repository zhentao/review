package com.zhentao.review.cracking;

/**
 * <b>17.11 Word Distance</>
 * <pre>
 * You have a large text file containing words. Given any two words, find the
 * shortest distance (in terms of number of words) between them in the file. If
 * the operation will be repeated many times for the same file (but different
 * pairs of words), can you optimize your solution?
 * </pre>
 * 
 * @author zhentao
 *
 */
public class WordDistance {
    public static int minDistance(String[] inputs, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int count = -1;
        String start = null;
        for (String word : inputs) {
            if (start != null) {
                count++;
            }
            if (word.equals(word1) || word.equals(word2)) {
                if (!word.equals(start) && start != null) {
                    if (min > count) {
                        min = count;
                    }
                }
                start = word;
                count = 0;
            }
        }
        return min;
    }
}
