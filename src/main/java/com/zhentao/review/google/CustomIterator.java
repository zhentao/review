package com.zhentao.review.google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 设计一个CustomIterator要求支持 next(), hasNext(), skip(int)
 * 三个功能。假设已经存在一个Iterator类，已经支持next(), hasNext()，你设计的类相当于是给定Iterator的wrapper
 * 
 * <pre>
 * 1, 2, 1, 3, 1, 4
skip(1);
skip(1);
next(); -> 2
next(); -> 3
skip(1);
next(); -> 4
 * </pre>
 * 
 * @author zhentao
 *
 */
public class CustomIterator<T> {
    private ListNode<T> head;
    private final ListNode<T> tail;
    // lookup node by value. ArrayList is not O(1) to remove the first element. must
    // use LinkedList
    private final HashMap<T, LinkedList<ListNode<T>>> keyToNode;

    public CustomIterator(final Iterator<T> iter) {
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        tail.prev = head;
        keyToNode = new HashMap<>();
        while (iter.hasNext()) {
            final ListNode<T> node = new ListNode<>(iter.next());
            insertBeforeTail(node);
            keyToNode.computeIfAbsent(node.key, k -> new LinkedList<ListNode<T>>()).add(node);
        }
    }

    private void insertBeforeTail(final ListNode<T> node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public boolean hasNext() {
        return head.next != tail;
    }

    public T next() {
        if (head.next == tail) {
            throw new NoSuchElementException();
        }
        head = head.next;
        // remove node from lookup table
        keyToNode.get(head.key).removeFirst();
        return head.key;
    }

    /**
     * Skip the value
     * 
     * @param val
     */
    public void skip(final T val) {
        // removeFirst is O(1) for LinkedList
        final ListNode<T> node = keyToNode.get(val).removeFirst();
        // remove the node for the list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static class ListNode<T> {
        ListNode<T> prev;
        ListNode<T> next;
        T key;

        public ListNode() {
        }

        public ListNode(final T key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }
}
