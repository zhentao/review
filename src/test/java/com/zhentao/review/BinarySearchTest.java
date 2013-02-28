package com.zhentao.review;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.zhentao.review.BinarySearch;

public class BinarySearchTest {
    private BinarySearch binarySearch;

    @Before
    public void setup() {
        this.binarySearch = new BinarySearch();
    }

    @Test
    public void findNoRecursiveShouldReturn() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 2;
        int expected = 1;
        assertEquals(expected, binarySearch.findNoRecursive(input, target));
    }

    @Test
    public void notFoundNoRecursive() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 6;
        int expected = -1;
        assertEquals(expected, binarySearch.findNoRecursive(input, target));
    }

    @Test
    public void findNoRecursiveTheLastElement() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 5;
        int expected = 4;
        assertEquals(expected, binarySearch.findNoRecursive(input, target));
    }

    @Test
    public void findNoRecursiveThFirstElement() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 1;
        int expected = 0;
        assertEquals(expected, binarySearch.findNoRecursive(input, target));
    }

    @Test
    public void findShouldReturn() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 2;
        int expected = 1;
        assertEquals(expected, binarySearch.find(input, target));
    }

    @Test
    public void notFound() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 6;
        int expected = -1;
        assertEquals(expected, binarySearch.find(input, target));
    }

    @Test
    public void findTheLastElement() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 5;
        int expected = 4;
        assertEquals(expected, binarySearch.find(input, target));
    }

    @Test
    public void findTheFirstElement() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 1;
        int expected = 0;
        assertEquals(expected, binarySearch.find(input, target));
    }

    @Test
    public void findShouldReturnFirst() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 2;
        int expected = 1;
        assertEquals(expected, binarySearch.findFirst(input, target));
    }

    @Test
    public void notFoundFirstLast() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 6;
        int expected = -1;
        assertEquals(expected, binarySearch.findFirst(input, target));
    }

    @Test
    public void notFoundFirstFirst() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 0;
        int expected = -1;
        assertEquals(expected, binarySearch.findFirst(input, target));
    }

    @Test
    public void notFoundFirstMiddle() {
        int[] input = {1, 2, 3, 5, 6};
        int target = 0;
        int expected = -1;
        assertEquals(expected, binarySearch.findFirst(input, target));
    }

    @Test
    public void findTheLastElementFirst() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 5;
        int expected = 4;
        assertEquals(expected, binarySearch.findFirst(input, target));
    }

    @Test
    public void findTheFirstElementFirst() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 1;
        int expected = 0;
        assertEquals(expected, binarySearch.findFirst(input, target));

    }

    @Test
    public void findFirstForDups() {
        int[] input = {1, 2, 3, 3, 4, 5};
        int target = 3;
        int expected = 2;
        assertEquals(expected, binarySearch.findFirst(input, target));
    }

    @Test
    public void findFirstNoDups() {
        int[] input = {1, 2, 3, 4, 5};
        int target = 2;
        int expected = 1;
        assertEquals(expected, binarySearch.findFirst(input, target));
    }
}
