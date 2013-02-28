package com.zhentao.review;

public class Node<T> {
    public Node<T> next;
    public T value;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
    public static <T> void reverse(Node<T> head) {
        Node<T> next = null;
        Node<T> previous = null;

        while (head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
    }

    public static <T> void reverseRecursive(Node<T> head) {
        reverseRecursive(head, null);
    }
    private static <T> void reverseRecursive(Node<T> current, Node<T> previous) {
        if (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            reverseRecursive(next, current);
        }
    }

    public static <T>void reverseNode(Node<T> node) {
        reverseNode(node, null);
    }

    private static <T> void reverseNode(Node<T> node, Node<T> previous) {
        if (node != null) {
            reverseNode(node.next, node);
            node.next = previous;
        }
    }
    public void print() {
        System.out.printf("%s ", value.toString());
        Node<T> temp = this;
        while(temp.next != null) {
            System.out.printf("%s ", temp.next.value.toString());
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
