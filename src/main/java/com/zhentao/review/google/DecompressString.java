package com.zhentao.review.google;

import java.util.Stack;

/**
 * <b>394. Decode String</b>
 * <pre>
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * </pre>
 * 
 * @author zhentao
 *
 */
public class DecompressString {
    public static void main(String[] args) {
        String compressed = "a3[b2[c1[d]]]e";
        System.out.println(decompress(compressed));
        System.out.println(decompress("10[a]"));
    }
    public static String decompress(String compressed) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        
        while (index < compressed.length()) {
            char c = compressed.charAt(index);

            if (c != ']') {
                stack.add(String.valueOf(c));
            } else {
                String decompressed = "";
                String s = stack.pop();
                while (!s.equals("[")) {
                    decompressed = s + decompressed;
                    s = stack.pop();
                }
                
                String countStr = "";
                char tempCh = stack.peek().charAt(0);
                while(tempCh >= '0' && tempCh <='9' && !stack.isEmpty()) {
                    countStr = tempCh+countStr;
                    stack.pop();
                    if (!stack.isEmpty()) {
                        tempCh = stack.peek().charAt(0);
                    }
                }
                int count = Integer.parseInt(countStr);
                String temp = "";

                for (int i = 0; i < count; i++) {
                    temp += decompressed;
                }
                stack.add(temp);

            }
            index++;
        }
        String builder = "";
        while(!stack.isEmpty()) {
            String s = stack.pop();
            builder = s + builder;
        }
        return builder;
    }
}
