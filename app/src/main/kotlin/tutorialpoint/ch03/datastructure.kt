package tutorialpoint.ch03
public sealed class List<out A> {
  public companion object {
    fun <A> of(vararg aa: A) : List<A> {
      val tail = aa.sliceArray(1 until aa.size)
      return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
    }
    fun sum(ints: List<Int>): Int =
      when (ints) {
        is Nil -> 0
        is Cons -> ints.head + sum(ints.tail)
    }
    fun product(doubles: List<Double>): Double =
      when (doubles) {
        is Nil -> 1.0
        is Cons -> doubles.head * product(doubles.tail)
      }
    fun <A> tail(xs: List<A>): List<A> =
      when (xs) {
        is Nil -> Nil
        is Cons -> xs.tail
      }
    fun <A> head(xs: List<A>): A? =
      when(xs) {
        is Nil -> null
        is Cons -> xs.head
      }
    fun <A> setHead(xs: List<A>, x: A) : List<A> =
      when {
        xs is Nil && x is Nil -> Nil
        x is Nil -> xs
        else -> Cons(x, xs)
      }
    tailrec fun <A> drop(l: List<A>, n: Int) :List<A> =
      when {
        l is Nil -> Nil
        n == 0 -> l
        else -> drop(tail(l), n-1)
      }
    fun <A> dropWhile(l: List<A>, f: (A?) -> Boolean) : List<A> =
      when {
        l is Nil -> Nil
        //l is Cons && f(l.head) == true -> l.tail
        f?.invoke(head(l)) == true -> tail(l)
        else -> dropWhile(tail(l), f)
      }
    fun<A> init(l: List<A>) : List<A> =
      when {
        l is Nil || tail(l) is Nil -> Nil
        else -> Cons(head(l), init(tail(l))) as List<A>
      }
  }
}
object Nil : List<Nothing>()
data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()
