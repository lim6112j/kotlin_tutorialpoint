/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tutorialpoint

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import tutorialpoint.ch02.*
import tutorialpoint.ch03.*
import tutorialpoint.ch03.List
import tutorialpoint.utils.*
import tutorialpoint.arrow.*
import tutorialpoint.arrow.prepareLunch
import arrow.core.Option
import arrow.core.Either
import kotlinx.coroutines.*
import tutorialpoint.designpattern.iterator.*
import tutorialpoint.designpattern.fIterator.*
import tutorialpoint.designpattern.observer.*
import tutorialpoint.designpattern.observer.fObserver.*
class App {
  val greeting: String
    get() {
      return "Hello World!"
    }
}

data class Customer(val name: String, val age: Int)

fun describe(value: Any): String =
    when (value) {
      1 -> "one"
      "hello" -> "greeting"
      is Long -> "value is long"
      !is String -> "value is not string"
      else -> "Unknown"
    }

fun multi(a: Int = 1, b: Int = 1): Int {
  return a * b
}

fun String.spaceToCamelCase() {
  // ...
}

object Resource {
  val name = "Name"
}

abstract class MyAbstractClass {
  public abstract fun doSomethin()
  public abstract fun sleep()
}

fun myTransform(color: String): Int =
    when (color) {
      "red" -> 1
      "yellow" -> 2
      "blue" -> 3
      else -> throw IllegalArgumentException("argument type is not string")
    }
/**
 * @param test int, string
 * @return class
 */
class Person(id: Int, name: String)
// discriminated union

/**
 * A function of *Factory*.
 *
 * abstract factory clone in functional code
 *
 * @param n/a the type of a system running code.
 * @param n/a the type of a ui component .
 * @property n/a
 * @constructor n/a
 */
sealed class MySystem {
  object Mac : MySystem()
  object Win : MySystem()
}

sealed class MyProduct {
  object Button : MyProduct()
  object Checkbox : MyProduct()
}

fun UnionPrint(system: MySystem): String {
  return when (system) {
    is MySystem.Mac -> "mac system"
    is MySystem.Win -> "window system"
  }
}
/**
 * creates UI component to this system.
 * @param *system* the type of a system running code.
 * @param *product* the type of a ui component .
 * @return *string* .
 */
fun factory(system: MySystem, product: MyProduct): String {
  return when {
    system is MySystem.Mac && product is MyProduct.Button -> "mac system making button"
    system is MySystem.Win && product is MyProduct.Checkbox -> "window system making checkbox"
    else -> "nothing"
  }
}

fun main() = runBlocking<Unit> {
  println(App().greeting)
  println(describe(1))
  for (x in 9 downTo 0 step 3) {
    println(x)
  }
  val items = listOf(1, 2, 3, 4)
  when {
    1 in items -> println("juicy")
    6 in items -> println("boo")
  }
  val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
  fruits.filter { it.startsWith("a") }.sortedBy { it }.map { it.uppercase() }.forEach {
    println(it)
  }
  val customer = Customer("lim", 22)
  println(customer.hashCode())
  println("a * b = ${multi(4,5)}")
  val positive = items.filter { x -> x > 0 }
  val negative = items.filter { it < 0 }
  println("items positive $positive")
  println("items negative $negative")

  // map
  val map = mapOf("a" to 1, "b" to 2, "c" to 3)
  println("map of items : $map")
  println("map[a] is ${map["a"]}")
  for ((k, v) in map) {
    println("$k -> $v")
  }
  val p: String by lazy { "hello" }
  println("lazy val p = $p")

  // val myObject =
  // object : MyAbstractClass() {
  // override fun doSomething() {
  // println("do something")
  // }
  // override fun sleep() {
  // println("sleep")
  // }
  // }
  // myObject.doSomething()
  println("trasform function : when single expression result : ${myTransform("red")}")
  // collection
  val numbers = listOf(0, 1, 2, 3, 4)
  println("list: ${numbers}")
  // reactive programming
  fun isEven(number: Int) = { (number % 2) == 0 }
  val subject: Subject<Int> = PublishSubject.create()
  subject
      .map({ isEven(it) })
      .subscribe({ println("The number is ${(if (it()) "Even" else "Odd")}") })
  subject.onNext(4)
  subject.onNext(9)
  Observable.just("hello reactive world").subscribe { value -> println(value) }
  println("fibo(4) is ${fibo(4)}")
  println("fiboRec(10) is ${fiboRec(10)}")
  val system = MySystem.Win
  val product = MyProduct.Checkbox
  println(factory(system, product))
  // List sealed class in ch03
  val data = Cons(1, Cons(2, Nil))
  println("data structure list ${data}")
  println(List.dropWhile(List.of(1, 2, 3), { x -> x == 2 }))
  println(List.init(List.of(1, 2, 3, 10)))
  println(List.foldRight(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 0, { x, y -> x + y }))
  println(List.foldRight(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1, { x, y -> x * y }))
  println(List.foldLeft(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 0, { x, y -> x + y }))
  // folding
  println("product with foldRight ${product(List.of(1.0,2.0,3.0))}")
  println(List.foldRight(Cons(1, Cons(2, Nil)), Nil as List<Int>, { x, y -> Cons(x, y) }))
  // length
  println("legnth of xs = ${length(List.of(1,2,3))}")
  // reverse
  println("reverse of xs : ${reverse(List.of(1,2,3))}")
  // foldR with foldL
  println("foldR with foldL : ${foldRWithFoldL(List.of(1,2,3), 0 ,{ x,y -> x + y })}")
  println(
      "foldR with foldL : ${foldRWithFoldL(List.of(1,2,3), Nil as List<Int> ,{ x,y -> Cons(x,y) })}"
  )
  // append with foldL
  println("append with foldL : ${appendR(List.of(1,2,3), List.of(4,5,6))}")
  // concatenate
  println("concatenate : ${concatenate(List.of(List.of(1,2,3), List.of(4,5,6)))}")
  // time check
  println(measureTimeMillis { Thread.sleep(100) })
  // int transformer
  println("add 1 to list : ${intTransformer(List.of(1,2,3))}")
  // int to string
  println("list to string : ${listToString(List.of(1.0,2.0,3.0))}")
  // arrow
  val option = Option(43)
  println("option value : ${option}")
  // filter
  println("filtering nil list : ${filter(Nil as List<Int>, {x -> x % 3 == 0})}")
  // filter2
  println("filter2 list : ${filter2(List.of(1,2,3,4,5,6), {x -> x % 2 == 0})}")
  // arrow
  launch {
    println("prepareLunch : ${prepareLunch()}")
  }
  val x = runChain("2")
  val value = 
    when (x) {
      is Either.Left -> when (x.value) {
        is Error.NotANumber -> "Not a number"
        is Error.NoZeroReciprocal -> "Can't take reciprocal of 0!"
      }
      is Either.Right -> "Got reciprocal : ${x.value}"
    }
  println("runchain x = 2 : ${value}")
  // iterator pattern
  println("\noop style iterator design pattern\n ---------------------------")
  val friends = MyFriends(listOf(Friend("ben", 22),Friend("John", 20)))
  val iterator = friends.createFriendsIterator()
  while(iterator.hasMore()) {
    val friend = iterator.next()
    println("friends printing : name ${friend?.name}, aged ${friend?.age}")
  }
  // functional iterator pattern
  println("\nfunctional style iterator design pattern\n ----------------------------")
  val ffriends = FFriends(listOf(FFriend("ben", 22), FFriend("John", 20)))
  tailrec fun ffriendsRec() : Unit =
      if(ffriends.hasMore()){
      val friend = ffriends.next()
      println("ffriend printing : name ${friend?.name}, aged ${friend?.age}")
      ffriendsRec()
      }
      else {println("end of friends\n")
    }
  ffriendsRec()
  // observer
  var subscribers = Subscribers(listOf())
  val publisher = Publisher(1, "Lim", subscribers)
  val subscriber = Subscriber(2, "Jane")
  val subscriber2 = Subscriber(3, "Tom")
  val subscriber3 = Subscriber(3, "Mary")
  println("first notifying ------------------")
  publisher.notify()
  subscriber.subscribe(publisher)
  println("second notifying ------------------")
  publisher.notify()
  subscriber2.subscribe(publisher)
  println("third notifying ------------------")
  publisher.notify()
  subscriber3.subscribe(publisher)
  println("forth notifying ------------------")
  publisher.notify()
  subscriber.unSubscribe(publisher)
  println("fifth notifying -----------------")
  publisher.notify()
}
