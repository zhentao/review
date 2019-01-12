package com.zhentao.review.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>346. Moving Average from Data Stream</b>
 * 
 * <pre>
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MovingAverage {
    private int window;
    private Queue<Integer> queue;
    private double total;

    public MovingAverage(int window) {
        this.window = window;
        queue = new LinkedList<>();
        total = 0;
    }

    public double next(int next) {
        if (queue.size() == window) {
            total -= queue.poll();
        }
        queue.add(next);
        total += next;
        return total / queue.size();
    }
}
