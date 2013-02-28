package com.zhentao.review;

class NumberFlags {
    // 25000 bits => 3125 bytes
    private final byte[] byteFlags = new byte[3126];

    public void put(int number) {
        int byteIndex = number / 8;
        int bitIndex = number % 8;
        byteFlags[byteIndex] = (byte) (byteFlags[byteIndex] | (1 << bitIndex));
    }

    public void remove(int number) {
        int byteIndex = number / 8;
        int bitIndex = number % 8;
        byteFlags[byteIndex] = (byte) (byteFlags[byteIndex] & ~(1 << bitIndex));
    }

    public boolean exists(int number) {
        int byteIndex = number / 8;
        int bitIndex = number % 8;
        int value = byteFlags[byteIndex] & (1 << bitIndex);
        return value > 0;
    }

    public NumberFlags findUnique(int[] array) {
        NumberFlags numberFlags = new NumberFlags();
        for (int i = 0; i < array.length; i++) {
            if (numberFlags.exists(array[i]))
                array[i] = -array[i];
            else
                numberFlags.put(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = -array[i];
                numberFlags.remove(array[i]);
            }
        }

        return numberFlags;
    }
}
