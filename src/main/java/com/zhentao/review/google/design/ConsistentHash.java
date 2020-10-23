package com.zhentao.review.google.design;

import java.util.Collection;
import java.util.Map.Entry;
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
    private final int numberOfVirtualNodes;
    private final TreeMap<Integer, T> circle = new TreeMap<>();

    /**
     * The circle is represented as a sorted map of integers, which represent the
     * hash values, to caches (of type T here). When a ConsistentHash object is
     * created each node is added to the circle map a number of times (controlled by
     * numberOfVirtualNodes). The location of each virtual node is chosen by hashing the
     * node's name along with a numerical suffix, and the node is stored at each of
     * these points in the map.
     *
     * @param hashFunction
     * @param numberOfVirtualNodes
     * @param nodes
     */
    public ConsistentHash(final HashFunction hashFunction, final int numberOfVirtualNodes, final Collection<T> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfVirtualNodes = numberOfVirtualNodes;

        for (final T node : nodes) {
            add(node);
        }
    }

    public void add(final T node) {
        for (int i = 0; i < numberOfVirtualNodes; i++) {
            circle.put(hashFunction.hashUnencodedChars(node.toString() + i).asInt(), node);
        }
    }

    public void remove(final T node) {
        for (int i = 0; i < numberOfVirtualNodes; i++) {
            circle.remove(hashFunction.hashUnencodedChars(node.toString() + i).asInt());
        }
    }

    /**
     * To find a node for an object (the get method), the hash value of the object
     * is used to look in the map. If the ceiling entry is null then we
     * wrap around the circle by getting the first key in the circle.
     *
     * @param key
     * @return
     */
    public T get(final Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = hashFunction.hashUnencodedChars(key.toString()).asInt();
        Entry<Integer, T> entry = circle.ceilingEntry(hash);
        if (entry == null) {
            entry = circle.firstEntry();
        }
        return entry.getValue();
    }
    //TODO use a circular linked list to store all nodes, then store objects in the first k nodes.
}
