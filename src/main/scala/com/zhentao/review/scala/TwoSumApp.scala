package com.zhentao.review.scala

import scala.collection.mutable.Map

object TwoSumApp extends App {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var map = Map[Int, Int]()
    val len = nums.length
    for (i <- 0.until(len)) {
      val diff = target - nums(i)
      if (map.contains(diff)) return Array(map(diff), i)
      map += (nums(i) -> i)
    }
    //you shouldn't come here
    Array(-1, -1)
  }

  val found = twoSum(Array(2, 7, 11, 15), 9)
  println(found(0) + ", " + found(1))

  val found1 = twoSum(Array(1, 2, 3, 4), 4)
  println(found1(0) + ", " + found1(1))

  def twoSum1(nums: Array[Int], target: Int): Array[Int] = {
    var map = Map[Int, Int]()
    val len = nums.length
    for (i <- 0.until(len)) {
      map.get(target - nums(i)) match {
        case Some(v) => return Array(v, i)
        case None => map += (nums(i) -> i)
      }
    }
    //you shouldn't come here
    Array(-1, -1)
  }

  val found2 = twoSum1(Array(1, 2, 3, 4), 4)
  println(found2(0) + ", " + found2(1))
}