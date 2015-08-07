package com.zhentao.review;

import java.util.HashMap;
import java.util.HashSet;

public class Duplicate {

    public static void main(String[] args) {
        String test = "cdbaca";

        Duplicate dup = new Duplicate();

        dup.printDups(test);
    }

    public void printDups(String input) {
        HashSet<Character> unique = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (unique.contains(currentChar)) {
                System.out.println("find dups: " + currentChar);
            } else {
                unique.add(currentChar);
            }
        }
    }

    /**
     * abac
     * @param input
     */
    public void findDupsCount(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (map.containsKey(currentChar)) {
                int count = map.get(currentChar);
                map.put(currentChar, count + 1);
            } else {
                map.put(currentChar, 0);
            }
        }
        //print the result
        for (Character ch : map.keySet()) {
            System.out.println(ch + ": " + map.get(ch));
        }
    }

    public String reverse(String original) {
        if (original == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int length = original.length();
        for (int i = length - 1; i >=0; i--) {
            result.append(original.charAt(i));
        }

        return result.toString();
    }
}
