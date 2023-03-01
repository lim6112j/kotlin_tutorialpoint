import arrow.core.None
import arrow.core.Option
import arrow.core.Some
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
sealed class Stream<out A> {
    public companion object {
        fun <A> Stream<A>.headOption(): Option<A> =
            when (this) {
                is Empty -> None
                is Cons -> Some(head())
            }
    }
}
data class Cons<out A>(
    val head: () -> A,
    val tail: () -> Stream<A>,
) : Stream<A>()
object Empty : Stream<Nothing> ()
