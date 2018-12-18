package com.zhentao.review;

import java.util.HashSet;
import java.util.Set;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (l1 != null || l2 != null || carry != 0) {
            int total = carry;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            int sum = total % 10;
            carry = total / 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list2_1 = new ListNode(1);
        ListNode list2_2 = new ListNode(9);
        ListNode list2_3 = new ListNode(9);
        ListNode list2_4 = new ListNode(9);
        ListNode list2_5 = new ListNode(9);
        ListNode list2_6 = new ListNode(9);
        ListNode list2_7 = new ListNode(9);
        ListNode list2_8 = new ListNode(9);
        ListNode list2_9 = new ListNode(9);
        ListNode list2_10 = new ListNode(9);
        list2_1.next = list2_2;
        list2_2.next = list2_3;
        list2_3.next = list2_4;
        list2_4.next = list2_5;
        list2_5.next = list2_6;
        list2_6.next = list2_7;
        list2_7.next = list2_8;
        list2_8.next = list2_9;
        list2_9.next = list2_10;

        ListNode list1 = new ListNode(9);
        ListNode addTwoNumbers = addTwoNumbers(list1, list2_1);
        System.out.println(addTwoNumbers);
        System.out.println(list2_9);

        lengthOfLongestSubstring("abcb");

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        int fn_2 = 0;
        int fn_1 = 1;
        for (int i = 2; i <= n; i++) {
            int fn = fn_2 + fn_1;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn_1;
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        String str = val + "";
        ListNode newNext = next;
        while (newNext != null) {
            str += newNext.val;
            newNext = newNext.next;
        }
        return str;
    }
}
