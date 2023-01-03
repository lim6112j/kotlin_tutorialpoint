package tutorialpoint.ch02
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
