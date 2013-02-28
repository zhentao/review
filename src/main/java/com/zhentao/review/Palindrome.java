package com.zhentao.review;

public class Palindrome {
    public static void main(String[] args) {
        String input = "1a2";
        System.out.println(check(input));
    }
    public static boolean check(String input) {
        if (input == null) return false;
        input = input.trim();
        if (input.equals("")) return true;

        int endIndex = input.length() - 1;
        int startIndex = 0;
        while (startIndex < endIndex) {
            char start = input.charAt(startIndex);
            char end = input.charAt(endIndex);
            if (!Character.isLetter(start) && !Character.isDigit(start) ) {
                startIndex++;
            } else if (!Character.isLetter(end) && !Character.isDigit(end)) {
                endIndex--;
            } else if (Character.toLowerCase(start) != Character.toLowerCase(end) ) {
                return false;
            } else {
                startIndex++;
                endIndex--;
            }
        }
        return true;
    }
}
