package com.zhentao.review.google.design;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.common.hash.HashFunction;

/**
 * The basic idea behind the consistent hashing algorithm is to hash both
 * objects and caches using the same hash function. The reason to do this is to
 * map the cache to an interval, which will contain a number of object hashes.
 * If the cache is removed then its interval is taken over by a cache with an
 * adjacent interval. All the other caches remain unchanged. The hash function
 * actually maps objects and caches to a number range
 * 
 * @author zhentao
 *
 * @param <T>
 */
public class ConsistentHash<T> {
    private final HashFunction hashFunction;
    private final int numberOfReplicas;
    private final SortedMap<Integer, T> circle = new TreeMap<>();

    /**
     * The circle is represented as a sorted map of integers, which represent the
     * hash values, to caches (of type T here). When a ConsistentHash object is
     * created each node is added to the circle map a number of times (controlled by
     * numberOfReplicas). The location of each replica is chosen by hashing the
     * node's name along with a numerical suffix, and the node is stored at each of
     * these points in the map.
     * 
     * @param hashFunction
     * @param numberOfReplicas
     * @param nodes
     */
    public ConsistentHash(final HashFunction hashFunction, final int numberOfReplicas, final Collection<T> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;

        for (final T node : nodes) {
            add(node);
        }
    }

    public void add(final T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hashFunction.hashString(node.toString() + i, Charset.defaultCharset()).asInt(), node);
        }
    }

    public void remove(final T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hashFunction.hashString(node.toString() + i, Charset.defaultCharset()).asInt());
        }
    }

    /**
     * To find a node for an object (the get method), the hash value of the object
     * is used to look in the map. Most of the time there will not be a node stored
     * at this hash value (since the hash value space is typically much larger than
     * the number of nodes, even with replicas), so the next node is found by
     * looking for the first key in the tail map. If the tail map is empty then we
     * wrap around the circle by getting the first key in the circle.
     * 
     * @param key
     * @return
     */
    public T get(final Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = hashFunction.hashString(key.toString(), Charset.defaultCharset()).asInt();
        if (!circle.containsKey(hash)) {
            final SortedMap<Integer, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
}
