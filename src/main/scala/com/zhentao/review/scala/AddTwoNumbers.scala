package com.zhentao.review.scala
import scala.math.BigInt

object AddTwoNumbers extends App {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var newL1 = l1
    var newL2 = l2
    val head = new ListNode()
    var tail = head
    var carry = 0
    while (newL1 != null || newL2 != null || carry > 0) {
      var sum = carry
      if (newL1 != null) {
        sum += newL1.x
        newL1 = newL1.next
      }
      if (newL2 != null) {
        sum += newL2.x
        newL2 = newL2.next
      }
      
      val value = sum % 10
      carry = sum / 10
      tail.next = new ListNode(value)
      tail = tail.next
    }
    
    head.next
  }
  
  
  
  
  
  def toInt(head: ListNode) : BigInt = {
    var times : BigInt= 1
    var result : BigInt = 0;
    var newHead = head
    while(newHead != null) {
      result += newHead.x * times
      times *= 10
      newHead = newHead.next
    }
    result
  }
  
  def toList(x: BigInt) : ListNode = {
    val str = x.toString()
    val len = str.length()
    var tail = new ListNode(str.charAt(0).asDigit);
    for (i <- 1.until(len)) {
      var current = new ListNode(str.charAt(i).asDigit)
      current.next = tail
      tail = current
    }
    tail
  }
  
  def toList1(x: BigInt) : ListNode = {
    
    val list = x.toString().map(_.asDigit)
    val len = list.size
    var tail = new ListNode(list(0));
    for (i <- 1.until(len)) {
      var current = new ListNode(list(i))
      current.next = tail
      tail = current
    }
    tail
  }
  
  
  var list1 = new ListNode(9)
 
  
  var list2_1 = new ListNode(1)
  var list2_2 = new ListNode(9)
  var list2_3 = new ListNode(9)
  var list2_4 = new ListNode(9)
  var list2_5 = new ListNode(9)
  var list2_6 = new ListNode(9)
  var list2_7 = new ListNode(9)
  var list2_8 = new ListNode(9)
  var list2_9 = new ListNode(9)
  var list2_10 = new ListNode(9)
  list2_1.next = list2_2
  list2_2.next = list2_3
  list2_3.next = list2_4
  list2_4.next = list2_5
  list2_5.next = list2_6
  list2_6.next = list2_7
  list2_7.next = list2_8
  list2_8.next = list2_9
  list2_9.next = list2_10
  
  val v = addTwoNumbers(list1, list2_1)
  println(v.x)
  println(v.next.x)
  println(v.next.next.x)
  println(v.next.next.next.x)
  
  println(toInt(list1) + toInt(list2_1))
}
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}