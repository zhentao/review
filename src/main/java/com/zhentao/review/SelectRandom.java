package com.zhentao.review;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SelectRandom {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 12000000; i++) {
            char picked = select(new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'});
            String key = String.valueOf(picked);
            Integer value = map.get(key);
            if (value == null) {
                value = 0;
            }
            value++;
            map.put(key, value);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
    public static char select(char[] input) {
        Random rand = new Random();
        char picked = input[0];
        int count = 1;
        for (char c : input) {
            if (rand.nextInt(count) == count - 1) {
                picked = c;
            }
            count++;
        }
        return picked;
    }
}
