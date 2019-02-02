package com.zhentao.review.google.design;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TaskScheduling implements Runnable {

    public static void main(final String[] args) {
        final DelayQueue<MyDelayedTask> queue = new DelayQueue<>();
        final TaskScheduling schedule = new TaskScheduling(queue);
        new Thread(schedule).start();
        schedule.set(new MyDelayedTask("1", System.currentTimeMillis() + 5000));// in 5 seconds
        schedule.set(new MyDelayedTask("2", System.currentTimeMillis() + 1000));// in 1 second;
    }

    private final DelayQueue<MyDelayedTask> queue;

    public TaskScheduling(final DelayQueue<MyDelayedTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final MyDelayedTask task = queue.take();
                new Thread(task).start();
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void set(final MyDelayedTask task) {
        queue.add(task);
    }
}

class MyDelayedTask implements Delayed, Runnable {
    String id;
    long startTime; // millis

    public MyDelayedTask(final String id, final long startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    @Override
    public int compareTo(final Delayed o) {
        return Long.valueOf(startTime).compareTo(((MyDelayedTask) o).startTime);
    }

    @Override
    public long getDelay(final TimeUnit unit) {
        final long delay = startTime - System.currentTimeMillis();
        return unit.convert(delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        System.out.println(toString() + " runs at " + System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return id + " start time: " + startTime;
    }
}
