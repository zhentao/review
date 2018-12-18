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

    public void shuffle(int[] array) {
        for (int i = array.length; i > 0; i--) {
            int index = ThreadLocalRandom.current().nextInt(i);
            swap(array, i-1, index);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
