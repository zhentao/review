package com.zhentao.review.cracking;

import com.zhentao.review.cracking.Node;

public class Node<T> {
	public Node<T> next;
	public T value;
	public Node(T value) {
		this.value = value;
	}
	public void print() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(value.toString());
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
			Node<T> temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}
}