package tutorialpoint.ch03
sealed class List<out A> {
  companion object {
    fun <A> of(vararg aa: A) : List<A> {
      val tail = aa.sliceArray(1 until aa.size)
      return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
    }
    fun sum(ints: List<Int>): Int =
      when (ints) {
        is Nil -> 0
        is Cons -> ints.head + sum(ints.tail)
        else -> -1
    }
    fun product(doubles: List<Double>): Double =
      when (doubles) {
        is Nil -> 1.0
        is Cons -> doubles.head * product(doubles.tail)
        else -> -1.0
      }
  }
}
object Nil : List<Nothing>()
data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()
