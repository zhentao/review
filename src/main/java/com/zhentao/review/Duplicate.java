package com.zhentao.review;

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
}
