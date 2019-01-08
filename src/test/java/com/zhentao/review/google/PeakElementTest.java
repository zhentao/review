package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PeakElementTest {

    private PeakElement peakElement;

    @Before
    public void setup() {
        peakElement = new PeakElement();
    }

    @Test
    public void testPeakLast() {
        assertThat(peakElement.find(new int[] { 1, 2, 3, 4, 5 }), is(4));
    }

    @Test
    public void testPeakFirst() {
        assertThat(peakElement.find(new int[] { 5, 4, 3, 2, 1 }), is(0));
    }

    @Test
    public void testPeak() {
        assertThat(peakElement.find(new int[] { 1, 2, 3, 1 }), is(2));
    }

    @Test
    public void testPeakOnLeft() {
        assertThat(peakElement.find(new int[] { 3, 4, 3, 2, 1 }), is(1));
    }

    @Test
    public void testPeakMid() {
        assertThat(peakElement.find(new int[] { 1, 2, 1 }), is(1));
    }

    @Test
    public void testPeak2Elements() {
        assertThat(peakElement.find(new int[] { 1, 2 }), is(1));
    }
    
    @Test
    public void testOneElement() {
        assertThat(peakElement.find(new int[] { 1 }), is(0));
    }
}
