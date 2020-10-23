package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 给个黑盒子，输入一个string，计算这个string里面每个字符出现的次数，输出按照频率高的先输出，
 * 如果频率相同，按照字母在string出现的先后顺序输出
 *
 * @author zhentao.li
 *
 */
public class OrderByFreq {
    public static void main(String[] args) {
        String str = "bbabcdeaae";
        OrderByFreq freq = new OrderByFreq();
        System.out.println(Arrays.toString(freq.order(str)));
    }

    public char[] order(String s) {
        HashMap<Character, CharObj> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).count++;
            } else {
                CharObj obj = new CharObj(c, i);
                map.put(c, obj);
            }
        }

        List<CharObj> list = new ArrayList<>(map.values());
        Collections.sort(list);
//        Collections.sort(list,
//                Comparator.comparingInt((CharObj c) -> c.count).thenComparingInt((CharObj c) -> c.order));
        char[] str = new char[list.size()];
        for (int i = 0; i < str.length; i++) {
            str[i] = list.get(i).ch;
        }

        return str;
    }

    private static class CharObj implements Comparable<CharObj> {
        char ch;
        int count;
        int order;

        CharObj(char ch, int order) {
            this.ch = ch;
            this.order = order;
        }

        @Override
        public int compareTo(CharObj o) {
            if (count == o.count) {
                return Integer.compare(order, o.order);
            }
            return -Integer.compare(count, o.count);
        }

        @Override
        public String toString() {
            return ch + " : " + count + " : " + order;
        }

    }
}
