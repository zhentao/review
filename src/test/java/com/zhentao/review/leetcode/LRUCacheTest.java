package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.zhentao.review.google.high.LRUCache;

public class LRUCacheTest {
    @Test
    public void testAnother2() {
        final LRUCache cache = new LRUCache(2);

        assertThat(cache.get(2), is(-1));
        cache.put(2, 6);
        assertThat(cache.get(1), is(-1));
        cache.put(1, 5);
        cache.put(1, 2);

        assertThat(cache.get(1), is(2));
        assertThat(cache.get(2), is(6));
    }

    @Test
    public void test2() {
        final LRUCache cache = new LRUCache(2);
        assertThat(cache.get(1), is(-1));

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1), is(1));
        cache.put(3, 3); // evicts key 2
        assertThat(cache.get(2), is(-1));
        cache.put(4, 4); // evicts key 1
        assertThat(cache.get(1), is(-1));
        assertThat(cache.get(3), is(3));
        assertThat(cache.get(4), is(4));
    }

    @Test
    public void test1() {
        final LRUCache cache = new LRUCache(1);
        assertThat(cache.get(1), is(-1));

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1), is(-1));
        assertThat(cache.get(2), is(2));
        cache.put(3, 3); // evicts key 2
        assertThat(cache.get(2), is(-1));
        cache.put(4, 4); // evicts key 3
        assertThat(cache.get(3), is(-1));
        assertThat(cache.get(4), is(4));
    }
}
