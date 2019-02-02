package com.zhentao.review.google.design;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    private static final int TOTAL_WINDOWS = 100;
    private static final int MILLIS_PER_SECOND = 1000;
    private final AtomicInteger[] windows;
    private final int qps;

    public RateLimiter(final int qps) {
        this.qps = qps;
        windows = new AtomicInteger[TOTAL_WINDOWS];// every 10 millis
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < windows.length; i++) {
            windows[i] = new AtomicInteger(0);
        }

        new Thread(new Runnable() {
            private int count = 0;
            @Override
            public void run() {
                while (true) {
                    windows[count % TOTAL_WINDOWS].set(0);
                    count++;
                    try {
                        TimeUnit.MILLISECONDS.sleep(MILLIS_PER_SECOND / TOTAL_WINDOWS);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public boolean allow() {
        final int index = (int) ((System.currentTimeMillis() / 10) % TOTAL_WINDOWS);
        final boolean allow = (sum(windows) <= qps);
        if (allow) {
            windows[index].incrementAndGet();
        }
        return allow;
    }

    private long sum(final AtomicInteger[] windows) {
        int total = 0;
        for (final AtomicInteger a : windows) {
            total += a.get();
        }
        return total;
    }

}
