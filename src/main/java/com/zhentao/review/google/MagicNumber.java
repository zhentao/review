package com.zhentao.review.google;

import java.util.HashMap;
import java.util.Set;

/**
 * This seems different from <b>246. Strobogrammatic Number</b>, which returns itself if it is
 * a Strobogrammatic Number.  The following asks for a different number.
 * @see StrobogrammaticNumberTest
 * 幻数：幻数是一个旋转180度的数字变成另一个数字。例如：6变为9,16变为91,809变为608等。 给出一个数字N检查它是否是一个幻数。
 * 
 * 跟进：报告从1到N的所有幻数。
 * 
 * @author zhentao
 *
 */
public class MagicNumber {
    public boolean check(final int input) {
        final char[] array = String.valueOf(input).toCharArray();
        final HashMap<Character, Character> map = new HashMap<Character, Character>() {
            private static final long serialVersionUID = 1L;
            {
                put('0', '0');
                put('1', '1');
                put('8', '8');
                put('6', '9');
                put('9', '6');
            }
        };
        int start = 0;
        int end = array.length - 1;
        final Set<Character> keySet = map.keySet();
        while (start <= end) {
            final char m = array[start];
            final char n = array[end];
            if (!keySet.contains(m) || !keySet.contains(n)) {
                return false;
            }
            if (map.get(m) == n) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
