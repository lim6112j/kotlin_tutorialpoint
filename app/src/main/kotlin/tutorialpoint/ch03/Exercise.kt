package tutorialpoint.ch03
import tutorialpoint.ch03.Cons
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
fun foldSum(ints:List<Int>): Int =
  foldLeft(ints, 0 , {x,y -> x+y})
fun foldProduct(doubles: List<Double>): Double =
  foldLeft(doubles, 1.0, {x,y -> x * y})
fun <A> foldLengh(xs: List<A>): Int =
  foldLeft(xs, 0, {acc, _ -> 1 + acc})
// exe 3.11
fun <A> reverse(xs: List<A>): List<A> =
  foldLeft(xs, Nil as List<A>, {y, x -> Cons(x, y)})
