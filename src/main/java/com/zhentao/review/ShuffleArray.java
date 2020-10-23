package com.zhentao.review;

import java.util.concurrent.ThreadLocalRandom;

public class ShuffleArray {
    public static void main(String[] args) {
        ShuffleArray shuffler = new ShuffleArray();
        int[] array = {1, 2, 3, 4, 5};
        shuffler.shuffle(array);
        for (int a : array) {
            System.out.println(a);
        }
    }
    /**
     * backward
     * @param array
     */
    public void shuffle(int[] array) {
        for (int i = array.length; i > 0; i--) {
            int index = ThreadLocalRandom.current().nextInt(i);
            swap(array, i-1, index);
        }
    }
    /**
     * forward
     * @param array
     */
    public void shuffle2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int index = ThreadLocalRandom.current().nextInt(i+1);
            swap(array, index, i);
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
