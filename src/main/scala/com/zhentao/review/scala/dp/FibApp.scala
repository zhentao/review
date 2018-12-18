package com.zhentao.review.scala.dp

object FibApp extends App {
  def fibWithMemo(n: Int): BigInt = {
    var memo: Array[BigInt] = new Array(n + 2)
    memo.foreach { println _ }
    memo(0) = 0
    memo(1) = 1
    for (i <- 2.to(n)) {
      memo(i) = memo(i - 1) + memo(i - 2)
    }
    memo(n)
  }

  def fib(n: Int): BigInt = {
    if (n == 0) return 0
    if (n == 1) return 1

    var fn_1: BigInt = 1
    var fn_2: BigInt = 0
    for (i <- 2.to(n)) {
      var fn = fn_1 + fn_2
      fn_2 = fn_1
      fn_1 = fn
    }
    fn_1
  }
fibWithMemo(4)

//  println(fibWithMemo(0))
//  println(fibWithMemo(1))
//  println(fibWithMemo(2))
//  println(fibWithMemo(3))
//  println(fibWithMemo(4))
//  println(fibWithMemo(100))
//  println(fib(100) == fibWithMemo(100))
}