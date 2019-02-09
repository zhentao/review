package com.zhentao.review.google.high;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <b>843. Guess the Word</b>
 * 
 * <pre>
 * We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.

You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.

Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.

Example 1:
Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]

Explanation:

master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.

We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class GuessTheWord {
    public void findSecretWord(String[] wordlist, final Master master) {
        for (int i = 0; i < 10; ++i) {
            //It holds the count that the word has zero matches with other words. 
            final HashMap<String, Integer> count = new HashMap<>();
            for (final String w1 : wordlist) {
                for (final String w2 : wordlist) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1, 0) + 1);
                    }
                }
            }
            String leastUnmatchedWord = null;//The word which matches others most
            int leastUnmatchedCount = Integer.MAX_VALUE;
            for (final String w : wordlist) {
                final int unmatchedCount = count.getOrDefault(w, 0);
                if (unmatchedCount < leastUnmatchedCount) {
                    leastUnmatchedWord = w;
                    leastUnmatchedCount = unmatchedCount;
                }
            }
            final int x = master.guess(leastUnmatchedWord);
            if (x == 6) {//found
                return;
            }
            final List<String> wordlist2 = new ArrayList<>();
            for (final String w : wordlist) {
                if (match(leastUnmatchedWord, w) == x && !w.equals(leastUnmatchedWord)) {//add words which have same match to the guess word to the new list
                    wordlist2.add(w);
                }
            }
            //reduce the word list
            wordlist = wordlist2.toArray(new String[0]);
        }
    }

    public int match(final String a, final String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == b.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}

/**
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6
 * matches. master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * 
 * @author zhentao
 *
 */
class Master {
    int guess(final String word) {
        switch (word) {
        case "aaaaaa":
            return 1;

        }
        return 0;
    }
}
