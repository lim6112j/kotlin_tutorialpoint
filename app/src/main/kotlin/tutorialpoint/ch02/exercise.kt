package tutorialpoint.ch02
fun fibo(i: Int): Int {
  fun go(n: Int): Int =
    when {
      n == 0 -> 0
      n == 1 -> 1
      else -> go(n-1) + go(n-2)
    }
  return go(i)
}
fun fiboRec(i: Int) : Int {
  tailrec fun go(n: Int, prev: Int, pprev: Int) : Int =
    when {
      n == 0 -> pprev
      else -> go(n-1, prev+pprev, prev)
    }
  return go(i, 1, 0)
}
val <A> List<A>.head: A
    get() = first()
val <A> List<A>.tail: List<A>
    get() = drop(1)

fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean =
        when {
            aa.tail.isEmpty() -> true
            order(aa.head, aa.tail.head) -> isSorted(aa.tail, order)
            else -> false
        }

fun <A> isSortedRec(aa: List<A>, order: (A, A) -> Boolean): Boolean {
    tailrec fun go(h: A, xs: List<A>): Boolean =
            when {
                xs.isEmpty() -> true
                !order(h, xs.head) -> false
                else -> go(xs.head, xs.tail)
            }
    return aa.isEmpty() || go(aa.head, aa.tail)
}

val order: (Int, Int) -> Boolean = { a, b -> a > b }
object Example {
  private fun abs(n: Int) : Int =
    if(n<0) -n
    else n
  private fun factorial(i: Int): Int {
    fun go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n * acc)
    return go(i, 1)
  }
  fun formatAbs(x: Int): String {
    val msg = "The absolute value of %d is %d"
    return msg.format(x, abs(x))
  }
  fun formatFactorial(x: Int): String {
    val msg = "The factorial of %d is %d"
    return msg.format(x, factorial(x))
  }
}

