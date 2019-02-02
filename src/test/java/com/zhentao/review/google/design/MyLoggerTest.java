package com.zhentao.review.google.design;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class MyLoggerTest {
    @Test
    public void test() {
        final MyLogger logger = new MyLogger();
        logger.started(100, "1");
        logger.started(101, "2");  
        logger.finished(102, "2");
        logger.started(103, "3");
        logger.finished(104, "1");
        logger.finished(105, "3");
         
        assertThat(logger.getFinishedLogs(), contains("1","2","3"));
    }
}
