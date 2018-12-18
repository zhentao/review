package com.zhentao.review.dp;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        generate(8);
    }

    public static void generate(int n) {
        if (n < 0) {
            throw new IllegalStateException("n must be greater than 0");
        }
        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        System.out.printf("%d ", f0);

        for (int i = 1; i <= n; i++) {
            BigInteger f = f0.add(f1);
            f0 = f1;
            f1 = f;
            System.out.printf("%d ", f0);
        }
    }
}
