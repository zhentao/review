package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IsomorphicStringsTest {
    @Test
    public void test() {
        final IsomorphicStrings isomorphic = new IsomorphicStrings();
        String s = "egg";
        String t = "add";

        assertThat(isomorphic.isIsomorphic(s, t), is(true));

        s = "foo";
        t = "bar";
        assertThat(isomorphic.isIsomorphic(s, t), is(false));
        
        s = "paper"; t = "title";
        assertThat(isomorphic.isIsomorphic(s, t), is(true));
    }
}
