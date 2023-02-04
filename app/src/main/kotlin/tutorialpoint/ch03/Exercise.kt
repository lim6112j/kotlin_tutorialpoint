package tutorialpoint.ch03
// exe 3.6
fun product(doubles: List<Double>): Double =
  when (doubles) {
    is Nil -> 1.0
    is Cons -> List.foldRight(doubles, 1.0, {x,y -> x*y})
  }
// exe 3.7
val copiedList = List.foldRight(Cons(1, Cons(2, Nil)), Nil as List<Int>, {x,y -> Cons(x , y)})
fun <A> empty() : List<A> = Nil
// exe 3.8
fun <A> length(xs: List<A>): Int =
  when (xs) {
    is Nil -> 0
    is Cons -> 1 + length(xs.tail)
  }
// exe 3.9
tailrec fun <A,B> foldLeft(l:List<A>, acc: B, f: (B, A) -> B) : B =
  when (l) {
    is Nil -> acc
    is Cons -> foldLeft(l.tail, f(acc, l.head), f)
  }
// exe 3.10
