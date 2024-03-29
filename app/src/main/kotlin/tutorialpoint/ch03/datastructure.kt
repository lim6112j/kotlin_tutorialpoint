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
    tailrec fun <A> dropWhile(l: List<A>, f: (A?) -> Boolean) : List<A> =
      when {
        l is Nil -> Nil
        //l is Cons && f(l.head) == true -> l.tail
        f.invoke(head(l)) == true -> tail(l)
        else -> dropWhile(tail(l), f)
      }
    fun<A> init(l: List<A>) : List<A?> =
      when {
        l is Nil || tail(l) is Nil -> Nil
        else -> Cons(head(l), init(tail(l))) 
      }
    fun <A,B> foldRight(l:List<A>, acc: B , f: (A,B) -> B) : B =
      when (l) {
        is Nil -> acc
        is Cons -> f(l.head, foldRight(l.tail, acc, f))
      }
    tailrec fun <A,B> foldLeft(l:List<A>, acc: B, f: (B, A) -> B) : B =
      when (l) {
        is Nil -> acc
        is Cons -> foldLeft(l.tail, f(acc, l.head), f)
      }
    fun <A> append(l1: List<A>, l2: List<A>): List<A> =
      when(l1) {
        is Nil -> l2
        is Cons -> Cons(l1.head, append(l1.tail, l2))
      }
  }
}
object Nil : List<Nothing>()
data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()
