package com.zhentao.review.google.high;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ExpiringCache<K, V> {
    public static void main(final String[] args) throws InterruptedException {
        final ExpiringCache<Integer, Integer> map = new ExpiringCache<>();
        map.put(1, 1, TimeUnit.SECONDS, 2);
        map.put(2, 2, TimeUnit.SECONDS, 2);
        map.put(3, 3, TimeUnit.SECONDS, 2);
         int count = 0;
        while (true) {
            for (int i = 1; i < 5; i++) {
                System.out.println(map.get(i));
            }
            TimeUnit.MILLISECONDS.sleep(500);
            if (count++ == 5) {
                break;
            }
        }
    }

    private final ConcurrentHashMap<K, Value<V>> map;

    public ExpiringCache() {
        map = new ConcurrentHashMap<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    final Iterator<K> iter = map.keySet().iterator();
                    while (iter.hasNext()) {
                        get(iter.next());//might throw ConcurrentModificationException
                    }
                }

            }
        }).start();
    }

    public V put(final K key, final V val, final TimeUnit unit, final long ttl) {
        final long duration = TimeUnit.MILLISECONDS.convert(ttl, unit);
        final Value<V> old = map.put(key, new Value<V>(val, duration));
        return old == null ? null : old.val;
    }

    public V get(final K key) {
        final Value<V> value = map.get(key);
        if (value != null) {
            if (value.isExpired()) {
                map.remove(key);
                return null;
            }
            return value.val;
        }
        return null;

    }

    static class Value<V> {
        V val;
        long expiredTimeInMillis;

        Value(final V val, final long duration) {
            this.val = val;
            expiredTimeInMillis = System.currentTimeMillis() + duration;
        }

        boolean isExpired() {
            return System.currentTimeMillis() - expiredTimeInMillis >= 0;
        }
    }
}
