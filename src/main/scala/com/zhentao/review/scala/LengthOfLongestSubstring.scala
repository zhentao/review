package com.zhentao.review.scala

import scala.collection.mutable.Set
import scala.math
object LengthOfLongestSubstring extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    val len = s.length()
    var set = Set[Char]()
    var result = 0
    var i = 0 
    var j = 0
    
    while (i < len && j < len) {
      val c = s.charAt(j)
      if (!set.contains(c)) {
        set.add(c)
        j += 1
        result = math.max(result, j - i)
      } else {
        set.remove(s.charAt(i))
        i += 1
      }
    }
    result
  }

  println(lengthOfLongestSubstring("abcdae"))
  println(-15/10)
}