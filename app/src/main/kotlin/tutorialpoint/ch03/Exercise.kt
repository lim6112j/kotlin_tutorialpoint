package tutorialpoint.ch03

// exe 3.6
fun product(doubles: List<Double>): Double =
    when (doubles) {
      is Nil -> 1.0
      is Cons -> List.foldRight(doubles, 1.0, { x, y -> x * y })
    }
// exe 3.7
val copiedList = List.foldRight(Cons(1, Cons(2, Nil)), Nil as List<Int>, { x, y -> Cons(x, y) })

fun <A> empty(): List<A> = Nil
// exe 3.8
fun <A> length(xs: List<A>): Int =
    when (xs) {
      is Nil -> 0
      is Cons -> 1 + length(xs.tail)
    }
// exe 3.9
fun <A, B> foldRight(l: List<A>, acc: B, f: (A, B) -> B): B =
    when (l) {
      is Nil -> acc
      is Cons -> f(l.head, foldRight(l.tail, acc, f))
    }

tailrec fun <A, B> foldLeft(l: List<A>, acc: B, f: (B, A) -> B): B =
    when (l) {
      is Nil -> acc
      is Cons -> foldLeft(l.tail, f(acc, l.head), f)
    }
// exe 3.10
fun foldSum(ints: List<Int>): Int = foldLeft(ints, 0, { x, y -> x + y })

fun foldProduct(doubles: List<Double>): Double = foldLeft(doubles, 1.0, { x, y -> x * y })

fun <A> foldLengh(xs: List<A>): Int = foldLeft(xs, 0, { acc, _ -> 1 + acc })
// exe 3.11
fun <A> reverse(xs: List<A>): List<A> = foldLeft(xs, Nil as List<A>, { y, x -> Cons(x, y) })
// exe 3.12
fun <A, B> flip(f: (A, B) -> B): (B, A) -> B = { x, y -> f(y, x) }

fun <A, B> foldRWithFoldL(xs: List<A>, acc: B, f: (A, B) -> B): B =
    when (xs) {
      is Nil -> acc
      is Cons -> foldLeft(reverse(xs), acc, flip(f))
    }
// exe 3.13
fun <A> appendR(l1: List<A>, l2: List<A>): List<A> =
    when (l1) {
      is Nil -> l2
      is Cons -> foldRight(l1, l2, { x, acc -> Cons(x, acc) })
    }
// exe 3.14
fun <A> concatenate(ll: List<List<A>>): List<A> =
    when (ll) {
      is Nil -> Nil
      is Cons ->
          foldRight(ll, Nil as List<A>, { x, acc -> foldRight(x, acc, { y, ac -> Cons(y, ac) }) })
    }
// exe 3.15
fun intTransformer(xs: List<Int>): List<Int> =
    when (xs) {
      is Nil -> Nil
      is Cons -> foldRight(xs, Nil as List<Int>, { x, acc -> Cons(x + 1, acc) })
    }
// exe 3.16
fun listToString(xs: List<Double>): List<String> =
    when (xs) {
      is Nil -> Cons("", Nil)
      is Cons -> foldRight(xs, Nil as List<String>, { x, acc -> Cons(x.toString(), acc) })
    }
// exe 3.17
fun <A, B> map(xs: List<A>, f: (A) -> (B)): List<B> =
  when (xs) {
    is Nil -> Nil
    is Cons -> Cons(f(xs.head), map(xs.tail, f))
  }
