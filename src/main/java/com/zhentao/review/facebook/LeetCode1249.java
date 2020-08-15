package com.zhentao.review.facebook;

import java.util.Stack;

public class LeetCode1249 {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        System.out.println(new LeetCode1249().minRemoveToMakeValid(s));
    }
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('(' == arr[i]) {
                stack.push(i);
            } else if (')' == arr[i]) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = '0';
                }
            }
        }
        while(!stack.isEmpty()) {
            arr[stack.pop()] = '0';
        }

        StringBuilder builder = new StringBuilder();
        for (char c : arr) {
            if (c != '0') {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
