package com.zhentao.review.google.high;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * <b>855. Exam Room</b>
 * 
 * <pre>
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)

Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.

 

Example 1:

Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
Output: [null,0,9,4,2,null,5]
Explanation:
ExamRoom(10) -> null
seat() -> 0, no one is in the room, then the student sits at seat number 0.
seat() -> 9, the student sits at the last seat number 9.
seat() -> 4, the student sits at the last seat number 4.
seat() -> 2, the student sits at the last seat number 2.
leave(4) -> null
seat() -> 5, the student sits at the last seat number 5.
​​​​​​​

Note:

1 <= N <= 10^9
ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 * </pre>
 * 
 * @author zhentao
 *
 */

/**
 * <pre>
 * 思路： 1.用优先队列： 用优先队列存slot，slot包含左右端点和长度。exclusive好算。注意如果是最左或最右时长度
 * 为right - left，若非则为(right - left) / 2，因为如果选择坐边上可以不管端点。seat时候去pq最大slot，
 * 中间切开offer两段。leave时候遍历找到左右两段整合
 * 
 * 离开时间复杂度 O(n) 坐下时间复杂度 O(logn)
 * 
 * 2. 用TreeSet 每次坐下时，遍历set找到最大的距离，并且记录位置，离开则直接删除目标数字
 * 
 * 离开时间复杂度O(logn) 坐下时间复杂度O(n)
 * </pre>
 */
public class ExamRoom {
    private final TreeSet<Integer> students;
    private final int capacity;

    public ExamRoom(final int N) {
        students = new TreeSet<>();
        capacity = N;
    }
    /**
     * O(N)
     * @return
     */
    public int seat() {
        final int size = students.size();
        if (size == capacity) {
            throw new RuntimeException("no more seats available");
        }
        int student = 0;

        if (size > 0) {
            int dist = students.first();// the distance to first student;
            Integer prev = null;
            for (final int curr : students) {
                if (prev != null) {
                    final int d = (curr - prev) / 2;
                    if (d > dist) {
                        student = prev + d;
                        dist = d;
                    }
                }
                prev = curr;
            }
            //fix the issue when the only student sits at the last spot
            if (capacity - 1 - students.last() > dist) {
                student = capacity - 1;
            }
        }
        students.add(student);
        return student;
    }
    /**
     * O(logN)
     * @param p
     */
    public void leave(final int p) {
        students.remove(p);
    }
}

class ExamRoom2 {
    private final ListNode head;
    private final ListNode tail;
    //seat # to Node
    private final HashMap<Integer, ListNode> map;
    int capacity;
    int size;
    public ExamRoom2(final int n) {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        capacity = n;
        size = 0;
    }
    
    /**
     * O(N)
     * @return
     */
    public int seat() {
        if (size == capacity) {
            throw new RuntimeException("no more seats available");
        }
        int student = 0;
        ListNode previous = head;
        if (size > 0) {
            int dist = head.next.number;// the distance to first student;
            ListNode prev = head;
            ListNode curr = head.next;
            
            while(curr != tail) {
                if (prev != head) {
                    final int d = (curr.number - prev.number) / 2;
                    if (d > dist) {
                        student = prev.number + d;
                        dist = d;
                        previous = prev;
                    }
                }
                prev = curr;
                curr = curr.next;
            }
            //check the last spot
            if (capacity - 1 - tail.prev.number > dist) {
                student = capacity - 1;
                previous = tail.prev;
            }
        }
        
        final ListNode node = new ListNode(student);
        node.next = previous.next;
        previous.next = node;
        node.next.prev = node;
        node.prev = previous;
        map.put(student, node);
        size++;
        return student;
    }
    
    /**
     * O(1)
     * @param p
     */
    public void leave(final int p) {
        final ListNode node = map.remove(p);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }
    
    static class ListNode {
        final int number;
        ListNode prev;
        ListNode next;
        ListNode(final int number) {
            this.number = number;
        }
        
        @Override
        public String toString() {
            return String.valueOf(number);
        }
    }
}
