package tutorialpoint.ch05
import tutorialpoint.ch03.Nil 
import tutorialpoint.ch03.Cons as ConsL 
import tutorialpoint.ch03.List 
sealed class Option<out A>
data class Some<out A>(val get: A) : Option<A>()
object None : Option<Nothing>()
fun <A> lazyIf(
    cond: Boolean,
    onTrue: () -> A,
    onFalse: () -> A,
): A = if (cond) onTrue() else onFalse()
val a = 10
val y = lazyIf((a < 22), { println("a") }, { println("b") })
fun maybeTwice(b: Boolean, i: () -> Int) =
    if (b) i() + i() else 0
fun maybeTwice2(b: Boolean, i: () -> Int) {
    val j: Int by lazy(i)
    if (b) j + j else 0
}
val maybeX = maybeTwice(true, { println("hio"); 1 + 41 })
val maybeX2 = maybeTwice2(true, { println("hi"); 1 + 41; })

// lazy lists or stream
sealed class Stream<out A>
data class Cons<out A>(
    val head: () -> A,
    val tail: () -> Stream<A>,
) : Stream<A>()
object Empty : Stream<Nothing> ()

fun <A> Stream<A>.headOption(): Option<A> =
    when (this) {
        is Cons -> Some(head())
        else -> None
    }
// exe 5.1
fun <A> Stream<A>.toList(): List<A> =
  when (this) {
    is Empty -> Nil
    is Cons -> ConsL(this.head(), this.tail().toList())
  }
// exe 5.2
fun <A> Stream<A>.take(n: Int): Stream<A> {
  tailrec fun <A> go(stream: Stream<A>, acc: Stream<A>, n: Int): Stream<A> =
    when {
      stream is Empty -> acc
      n == 0 -> acc
      stream is Cons -> go(stream.tail(), Cons(stream.head, {-> acc}), n-1)
      else -> Empty
    }
  return go(this, Empty, n)
}
