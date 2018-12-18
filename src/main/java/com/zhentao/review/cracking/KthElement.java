package com.zhentao.review.cracking;

/** <b>2.2 Kth Element to last</b>
 * 
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 * @author zhentao.li
 *
 */
public class KthElement {
	public static Node<Integer> kth(Node<Integer> head, int k) {
		Node<Integer> first = head;
		for (int i = 0; i < k; i++) {
			if (first == null) {
				return null;
			}
			first = first.next;
		}
		Node<Integer> second = head;
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		return second;
	}
}
