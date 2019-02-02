package com.zhentao.review.cracking;

public class Node<T> {
	public Node<T> next;
	public T value;
	public Node(final T value) {
		this.value = value;
	}
	public void print() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(value.toString());
		Node<T> temp = next;
		while(temp != null) {
			builder.append("->" + temp.value);
			temp = temp.next;
		}
		return builder.toString();
	}
	
	public Node<T> reverse() {
		Node<T> prev = null;
		Node<T> current = this;
		while (current != null) {
			final Node<T> temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}
}