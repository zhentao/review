package com.zhentao.review.google.design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 有一个Class叫Logger，它有两个函数，一个是LogStart(int logId, int timestamp)，一个是LogFinish(int
 * logId, int timestamp)。Log开始时LogStart会被调用，log结束时LogFinish会被调用。要求是实现这两个函数，
 * 并打印已经结束的log，打印log时要按log的开始时间排序。
 * 
 * <pre>
 * interface Logger {
 *     void started(long timestamp, String requestId);
 * 
 *     void finished(long timestamp, String requestId);
 * }
 * 
 * started(100, "1")
started(101, "2")   
finished(102, "2")
started(103, "3")
finished(104, "1")
finished(105, "3")

Expected Output:
1 start at 100 end at 104
2 start at 101 end at 102
3 start at 103 end at 105
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MyLogger implements Logger {
    private final ConcurrentHashMap<String, LogData> started = new ConcurrentHashMap<>();
    private final TreeSet<LogData> finished = new TreeSet<>();
    @Override
    public void started(final long timestamp, final String requestId) {
        started.put(requestId, new LogData(requestId, timestamp));
    }

    @Override
    public void finished(final long timestamp, final String requestId) {
        final LogData data = started.remove(requestId);
        data.end = timestamp;
        finished.add(data);
    }
    
    public List<LogData> getFinishedLogs() {
        return new ArrayList<>(finished);
    }
}

class LogData implements Comparable<LogData> {
    final String requestId;
    final long start;
    long end;
    public LogData(final String requestId, final long start) {
        this.requestId = requestId;
        this.start = start;
    }
    @Override
    public int compareTo(final LogData o) {
        return Long.valueOf(start).compareTo(o.start);
    }
    
    @Override
    public String toString() {
        return requestId + " start at " + start + " end at " + end;
    }
}

interface Logger {
    void started(long timestamp, String requestId);

    void finished(long timestamp, String requestId);
}
