package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReadNByRead4MultipleTest {
    private ReadNByRead4Multiple multiple;

    @Test
    public void test() {
        multiple = new ReadNByRead4Multiple() {
            private char[] str = "abcdefghijklmno".toCharArray();
            private int current = 0;
            private int size1 = str.length;

            @Override
            public int read4(char[] buffer) {
                int length = Math.min(4, size1 - current);
                System.arraycopy(str, current, buffer, 0, length);
                current = Math.min(size1, current + 4);
                return length;
            }

        };
        
        char[] buff = new char[8];
        assertThat(multiple.read(buff, buff.length), is(8));
        assertThat(buff, is("abcdefgh".toCharArray()));
        
        buff = new char[1];
        assertThat(multiple.read(buff, buff.length), is(1));
        assertThat(buff, is("i".toCharArray()));
        
        buff = new char[5];
        assertThat(multiple.read(buff, buff.length), is(5));
        assertThat(buff, is("jklmn".toCharArray()));
        
        buff = new char[3];
        assertThat(multiple.read(buff, buff.length), is(1));
        assertThat(buff[0], is('o'));
        assertThat(buff[1], is('\0'));
    }
}
