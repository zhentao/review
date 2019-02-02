package com.zhentao.review.google.design;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class RateLimiterTest {

    @Test
    public void test(){
        final int qps = 200;
        final RateLimiter limitter = new RateLimiter(qps);
        final RateLimiterRunner test = new RateLimiterRunner(limitter);
        while(true) {
            test.run();
        }
    }
}

class RateLimiterRunner {
    private final RateLimiter limiter;
    int count = 0;
     RateLimiterRunner(final RateLimiter limiter) {
        this.limiter = limiter;
    }
    
    public void run() {
        
        if(limiter.allow()) {
            count++;
            System.out.println("allow to run " + count);
        } else {
            System.out.println("over limit, drop request");
            count = 0;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
