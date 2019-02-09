package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.junit.Test;
public class DecodeBinaryTest {
    @Test
    public void test() {
        final DecodeBinary decode = new DecodeBinary();
        final HashMap<String, Character> map = new HashMap<>();
        map.put("00", 'a');
        map.put("0101", 'b');
        map.put("0111", 'c');
        map.put("0100", 'd');
        map.put("01", 'e');
        
        assertThat(decode.decode("01010111010001", map), anyOf(is("bcde"), is("eeceae")));
    }
    
    @Test
    public void test2() {
        final DecodeBinary decode = new DecodeBinary();
        final HashMap<String, Character> map = new HashMap<>();
        map.put("00", 'a');
        map.put("0101", 'b');
        map.put("0111", 'c');
        map.put("0100", 'd');
        map.put("01", 'e');
        assertThat(decode.decode("010101110100011111", map), is(""));
    }
}
