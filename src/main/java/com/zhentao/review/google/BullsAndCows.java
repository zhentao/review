package com.zhentao.review.google;

import java.util.HashMap;

/**
 * <b>299. Bulls and Cows</b>
 * 
 * <pre>
 * You are playing the following Bulls and Cows game with your friend: You write down a number 
 * and ask your friend to guess what the number is. Each time your friend makes a guess, you 
 * provide a hint that indicates how many digits in said guess match your secret number exactly 
 * in both digit and position (called "bulls") and how many digits match the secret number but 
 * locate in the wrong position (called "cows"). Your friend will use successive guesses and 
 * hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, 
use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class BullsAndCows {
    /**
     * This implementation can be used for non-digital input
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(final String secret, final String guess) {
        if (secret == null || secret.length() == 0) {
            return "";
        }
        final HashMap<Character, Integer> secretMap = new HashMap<>();
        final HashMap<Character, Integer> guessMap = new HashMap<>();

        int a = 0;
        int b = 0;

        for (int i = 0; i < secret.length(); i++) {
            final char s = secret.charAt(i);
            final char g = guess.charAt(i);
            if (s != g) {
                int count;
                if (secretMap.containsKey(g) && (count = secretMap.get(g)) > 0) {
                    b++;
                    secretMap.put(g, count - 1);
                } else {
                    guessMap.compute(g, (k, v) -> v == null ? 1 : v + 1);
                }

                if (guessMap.containsKey(s) && (count = guessMap.get(s)) > 0) {
                    b++;
                    guessMap.put(s, count - 1);
                } else {
                    secretMap.compute(s, (k, v) -> v == null ? 1 : v + 1);
                }

            } else {
                a++;
            }
        }
        return a + "A" + b + "B";
    }

    /**
     * this implementation bases on the input is number
     * @param secret
     * @param guess
     * @return
     */
    public String getHint2(final String secret, final String guess) {
        int bulls = 0;
        int cows = 0;
        final int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            final int s = Character.getNumericValue(secret.charAt(i));
            final int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bulls++;
            } else {
                if (numbers[s] < 0) {
                    cows++;
                }
                if (numbers[g] > 0) {
                    cows++;
                }
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
