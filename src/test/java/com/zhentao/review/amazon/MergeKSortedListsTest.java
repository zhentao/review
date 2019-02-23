package com.zhentao.review.amazon;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.zhentao.review.amazon.MergeKSortedLists.ListNode;
public class MergeKSortedListsTest {
    @Test
    public void test() {
        final MergeKSortedLists merge = new MergeKSortedLists();

        final ListNode list1_1 = new ListNode(1);
        final ListNode list1_4 = new ListNode(4);
        final ListNode list1_5 = new ListNode(5);
        list1_1.next = list1_4;
        list1_4.next = list1_5;

        final ListNode list2_1 = new ListNode(1);
        final ListNode list2_3 = new ListNode(3);
        final ListNode list2_4 = new ListNode(4);
        list2_1.next = list2_3;
        list2_3.next = list2_4;

        final ListNode list3_2 = new ListNode(2);
        final ListNode list3_6 = new ListNode(6);
        list3_2.next = list3_6;

        final ListNode[] lists = new ListNode[] {list1_1, list2_1, list3_2};

        final ListNode result1 = new ListNode(1);
        final ListNode result2 = new ListNode(1);
        final ListNode result3 = new ListNode(2);
        final ListNode result4 = new ListNode(3);
        final ListNode result5 = new ListNode(4);
        final ListNode result6 = new ListNode(4);
        final ListNode result7 = new ListNode(5);
        final ListNode result8 = new ListNode(6);
        result1.next = result2;
        result2.next = result3;
        result3.next = result4;
        result4.next = result5;
        result5.next = result6;
        result6.next = result7;
        result7.next = result8;

        assertThat(merge.mergeKLists(lists ), is(result1));
    }
}
