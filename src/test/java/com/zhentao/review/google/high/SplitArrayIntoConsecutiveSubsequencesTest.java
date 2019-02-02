package com.zhentao.review.google.high;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SplitArrayIntoConsecutiveSubsequencesTest {
    @Test
    public void test() {
        final SplitArrayIntoConsecutiveSubsequences split = new SplitArrayIntoConsecutiveSubsequences();
         int[] nums = {1,2,3,3,4,5};
        assertThat(split.isPossible(nums ), is(true));
        
        nums = new int[]{1,2,3,3,4,4,5,5};
        assertThat(split.isPossible(nums ), is(true));
        
        nums = new int[] {1,2,3,4,4,5};
        assertThat(split.isPossible(nums ), is(false));
    }
}
