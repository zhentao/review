package com.zhentao.review.google;

import java.util.Iterator;
import java.util.List;

/**
 * 给出一个List<Integer>, 写一个iterator，写一个iterator来遍历其中所有的偶数 e.g. [1, 3, 7, 9, 11,
 * 12, 13, 2, 1], 可以遍历[12, 2]
 * 
 * @author zhentao
 *
 */
public class EvenIterator {
    private final Iterator<Integer> iter;

    public EvenIterator(final List<Integer> list) {
        this.iter = list.iterator();
    }

    public Integer next() {
        while (iter.hasNext()) {
            final Integer next = iter.next();
            if (next % 2 == 0) {
                return next;
            }
        }
        return null;
    }
}
