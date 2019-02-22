package com.zhentao.review.amazon;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KClosestPointsToOriginTest {
    @Test
    public void test() {
        final KClosestPointsToOrigin kClose = new KClosestPointsToOrigin();
        final int[][] points = { { 1, 1 }, { 1, 2 }, { 1, 3 } };
        assertThat(kClose.kClosest(points, 2), arrayContainingInAnyOrder(new int[][] { { 1, 1 }, { 1, 2 } }));

//        int count = 1;
//        final Set<Integer> set = new HashSet<>();
//        int value = 0;
//        do {
//            value = 58 * count + 44;
//            set.add(value);
//            count++;
//        } while (value < 3000);
//
//        count = 1;
//        value = 32*count + 30;
//        while(value < 3000) {
//            if (set.contains(value)) {
//                System.out.println(value);
//            }
//            count++;
//            value = 32*count+30;
//        }
        System.out.println (798 % 32);
        System.out.println (798 % 58);

        System.out.println (1726 % 32);
        System.out.println (1726 % 58);

        System.out.println (2654 % 32);
        System.out.println (2654 % 58);
    }
}
