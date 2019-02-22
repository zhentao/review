package com.zhentao.review.amazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b>819. Most Common Word</b>
 *
 * <pre>
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.



Note:

    1 <= paragraph.length <= 1000.
    1 <= banned.length <= 100.
    1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 * </pre>
 *
 * @author zhentao
 *
 */
public class MostCommonWord {
    public String mostCommonWord(final String paragraph, final String[] banned) {
        final Set<String> bannedSet = new HashSet<>();
        Collections.addAll(bannedSet, banned);
        String mostCommon = "";
        int count = 0;
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : paragraph.toLowerCase().split("\\W+")) {
            if (!bannedSet.contains(word)) {
                counts.merge(word, 1, Integer::sum);
                final Integer currCount = counts.get(word);
                if (currCount > count) {
                    count = currCount;
                    mostCommon = word;
                }
            }
        }
        return mostCommon;
    }

    public String mostCommonWord2(final String paragraph, final String[] banned) {
        final Set<String> bannedSet = new HashSet<>();
        Collections.addAll(bannedSet, banned);
        String mostCommon = "";
        int count = 0;
        final Map<String, Integer> counts = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        final char[] charArray = paragraph.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            final char c = Character.toLowerCase(charArray[i]);
            if (Character.isLetter(c)) {
                builder.append(c);
            } else {
                if (builder.length() != 0) {
                    final String str = builder.toString();
                    if (!bannedSet.contains(str)) {
                        counts.merge(str, 1, Integer::sum);
                        final Integer currCount = counts.get(str);
                        if (currCount > count) {
                            count = currCount;
                            mostCommon = str;
                        }
                    }
                    builder = new StringBuilder();
                }
            }
        }
        if (builder.length() != 0) {
            final String str = builder.toString();
            if (!bannedSet.contains(str)) {
                counts.merge(str, 1, Integer::sum);
                final Integer currCount = counts.get(str);
                if (currCount > count) {
                    count = currCount;
                    mostCommon = str;
                }
            }
        }
        return mostCommon;
    }
}
