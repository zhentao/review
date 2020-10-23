package com.zhentao.review.facebook;

public class Cipher {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
    }
    public String rotationalCipher(String input, int rotationFactor) {
        char[] upper = new char[26];
        char[] lower = new char[26];
        for (int i = 0; i < 26; i++) {
            upper[i] = (char)('A' + i);
            lower[i] = (char)('a' + i);
        }
        int digits = 10;
        StringBuilder builder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                builder.append((ch - '0' + rotationFactor) % digits);
            } else if (Character.isUpperCase(ch)) {
                builder.append(upper[(ch - 'A' + rotationFactor) % 26]);
            } else if (Character.isLowerCase(ch)) {
                builder.append(lower[(ch - 'a' + rotationFactor) % 26]);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
