package com.zhentao.review.cracking;

/**
 * for linked list, pad or chop one of the list to make 2 of them the same size. 
 */
/**
 * <b>2.5 Sum Lists</b>
 * 
 * <pre>
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295.
Output: 2 - > 1 - > 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
Output: 9 - > 1 - > 2. That is, 912.
 * </pre>
 * 
 * @author zhentao.li
 *
 */
public class SumList {
	public static void main(String[] args) {
		Node<Integer> list1 = new Node<>(9);
		list1.next = new Node<>(3);
		Node<Integer> list2 = new Node<>(3);
		list2.next = new Node<>(9);
		Node<Integer> list = backwardSum(list1, list2);
		list.print();

		list = forwardSum(list1, list2);
		list.print();
	}

	public static Node<Integer> backwardSum(Node<Integer> list1, Node<Integer> list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		int carry = 0;

		int value = list1.value + list2.value;
		carry = value / 10;
		value = value % 10;
		
		Node<Integer> current = new Node<>(value);

		Node<Integer> next1 = list1.next;
		Node<Integer> next2 = list2.next;
		Node<Integer> head = current;
		while (next1 != null || next2 != null || carry != 0) {
			if (next1 == null && next2 == null) {
				current.next = new Node<>(carry);
				return head;
			} else if (next1 == null) {
				value = next2.value + carry;
				next2 = next2.next;
			} else if (next2 == null) {
				value = next1.value + carry;
				next1 = next1.next;
			} else {
				value = next1.value + next2.value + carry;
				next1 = next1.next;
				next2 = next2.next;
			}
			
			carry = value / 10;
			value = value % 10;
			
			
			current.next = new Node<>(value);
			current = current.next;
		}

		return head;
	}
	/**
	 * You can add zeros to the front of the shorter list to make the 2 list have the same length
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static Node<Integer> forwardSum(Node<Integer> list1, Node<Integer> list2) {
		Node<Integer> reversedList1 = list1.reverse();
		Node<Integer> reversedList2 = list2.reverse();
		Node<Integer> result = backwardSum(reversedList1, reversedList2);
		return result.reverse();
	}
}
