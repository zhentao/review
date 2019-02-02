package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class RandomizedSetTest {

    @Test
    public void test() {
        final RandomizedSet set = new RandomizedSet();
        for (int i = 1000000000; i <= 1000000099; i++) {
            set.insert(i);
        }
        for (int i = -1000000000; i >= -1000000099; i--) {
            set.insert(i);
        }
        for (int i = 0;i < 100; i++) {
            set.getRandom();
        }
        
        for (int i = 1000000000; i <= 1000000099; i++) {
            set.remove(i);
        }
        for (int i = -1000000000; i >= -1000000099; i--) {
            set.remove(i);
        }
        
//        assertThat(set.remove(0), is(false));
//        assertThat(set.remove(0), is(false));
//        assertThat(set.insert(0), is(true));
//        assertThat(set.getRandom(), is(0));
//        assertThat(set.remove(0), is(true));
//        assertThat(set.insert(0), is(true));
//        assertThat(set.insert(1), is(true));
//        assertThat(set.insert(2), is(true));
//        assertThat(set.insert(2), is(false));
//        assertThat(set.remove(3), is(false));
//        assertThat(set.remove(1), is(true));
    }
    
    public static List<String> findRepeatedDnaSequences(final String s) {
        final HashSet<String> seen = new HashSet<>();
        final HashSet<String> repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            final String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList<>(repeated);
    }
    
   @Test
   public void test2() {
       final String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
       System.out.println(findRepeatedDnaSequences(s));
   }
}
