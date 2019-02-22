package com.zhentao.review.uber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class ExclusiveTimeOfFuncationsTest {
    @Test
    public void test() {
        final ExclusiveTimeOfFuncations exclusive = new ExclusiveTimeOfFuncations();
        assertThat(exclusive.exclusiveTime(2, List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6")),
                is(new int[] { 3, 4 }));
        assertThat(
                exclusive.exclusiveTime(2,
                        List.of("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8")),
                is(new int[] { 8, 1 }));

        assertThat(
                exclusive.exclusiveTime(3,
                        List.of("0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3")),
                is(new int[] { 1, 1, 2 }));

    }
}
