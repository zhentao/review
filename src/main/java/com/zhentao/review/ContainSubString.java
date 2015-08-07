package com.zhentao.review;

public class ContainSubString {
    public static void main(String[] args) {
        System.out.println(contains("abcde", "de"));
    }

    public static int contains(String mainStr, String subStr) {
        int sub = subStr.length();
        int main = mainStr.length();

        for (int i = 0; i <= main - sub; i++) {
            String temp = mainStr.substring(i, i + sub);
            if (temp.equals(subStr)) {
                return i;
            }
        }
        return -1; // not found
    }
}
