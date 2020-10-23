package com.zhentao.review.facebook;

import java.util.Stack;

/**
 * <b>227. Basic Calculator II<b>
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 *
 * <pre>
Example 1:

Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:

Input: " 3+5 / 2 "
Output: 5

Note:

    You may assume that the given expression is always valid.
    Do not use the eval built-in library function.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0227 {
    public static void main(String[] args) {
        int result = new LeetCode0227().calculate("42");
        System.out.println(result);
    }

    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (i == s.length()-1 || (!Character.isDigit(ch) && ch != ' ')) {
                switch (operator) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop()*num);
                    break;
                case '/':
                    stack.push(stack.pop()/num);
                    break;
                }
                operator = ch;
                num = 0;
            }
        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }











    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char previousOp = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (i == s.length() - 1 || (!Character.isDigit(ch) && ch != ' ')) {
                switch (previousOp) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
                }
                previousOp = ch;
                num = 0;
            }
        }

        return stack.stream().reduce(0, Integer::sum);
    }

    public int calculate1(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
            case '+':
            case '-':
                if (stack.size() == 2) {
                    String operator = stack.pop();
                    int first = Integer.parseInt(stack.pop());
                    int second = Integer.parseInt(builder.toString().trim());
                    int value = operator.equals("+") ? first + second : first - second;
                    builder = new StringBuilder(String.valueOf(value));
                }
                stack.push(builder.toString().trim());
                builder = new StringBuilder();
                stack.push(String.valueOf(ch));

                break;

            case '*':
            case '/':
                char operator = ch;
                int first = Integer.parseInt(builder.toString().trim());

                builder = new StringBuilder();
                i++;
                for (; i < s.length(); i++) {
                    ch = s.charAt(i);
                    if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
                        builder.append(ch);
                    } else {
                        break;
                    }
                }
                i--;
                int second = Integer.parseInt(builder.toString().trim());

                int value = operator == '*' ? first * second : first / second;
                builder = new StringBuilder(String.valueOf(value));
                break;
            default:
                builder.append(ch);
            }
        }
        if (builder.length() != 0) {
            stack.push(builder.toString().trim());
        }
        if (stack.size() == 1) {
            return Integer.parseInt(stack.pop());
        } else {
            int second = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int first = Integer.parseInt(stack.pop());

            switch (op) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            }
        }
        return 0;
    }
}
