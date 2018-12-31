package com.zhentao.review.cracking;

import java.util.Arrays;
import java.util.Iterator;

public class CircularArray<E> implements Iterable<E> {
    private E[] data;
    private int size;
    private int index;
    private boolean isFull;

    @SuppressWarnings("unchecked")
    public CircularArray(int size) {
        this.size = size;
        data = (E[]) new Object[size];
        index = -1;
    }

    public CircularArray() {
        this(10);
    }

    /**
     * add the element to the back of array
     * 
     * @param element
     */
    public void add(E element) {
        index++;
        
        index = (index == size) ? 0: index;
        isFull = (index == size);
        
        data[index] = element;
    }

    public E get() {
        return data[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new CircularArrayIterator<E>(data, index, isFull);
    }

    private static class CircularArrayIterator<E> implements Iterator<E> {
        private E[] data;
        private int index;
        private int count;
        private boolean isFull;

        public CircularArrayIterator(E[] data, int index, boolean isFull) {
            this.data = data;
            this.index = index;
            this.isFull = isFull;
        }

        @Override
        public boolean hasNext() {
            return count != data.length;
        }

        @Override
        public E next() {
            
            if (index == data.length) {
                index = 0;
            }
            count++;
            return data[index++];
        }

    }
    
    public static int max(int[] array) {
        int maxSofar = 0;
        int maxAll = 0;
//        int[] dp = new int[array.length+1];
//        
//        dp[0] = 0;
//        for (int i = 0; i < array.length; i++) {
//            dp[i+1] = dp[i+1] + dp[i];
//            if (maxAll < dp[i]) {
//                maxAll = dp[i];
//            }
//        }
        
        for (int x : array) {
            maxSofar += x;
            if (maxSofar < 0) {
                maxSofar = 0;
            }
            if (maxAll < maxSofar) {
                maxAll = maxSofar;
            }
        }
        
        return maxAll;
    }
}
