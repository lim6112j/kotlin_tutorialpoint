/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tutorialpoint

import io.reactivex.rxjava3.subjects.Subject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.core.Observable
import tutorialpoint.ch02.*
import tutorialpoint.ch03.List
import tutorialpoint.ch03.*
import tutorialpoint.MySystem

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
fun UnionPrint( system: MySystem): String {
    return when(system) {
        is MySystem.Mac -> "mac system"
        is MySystem.Win -> "window system"
    }
}
    /**
     * creates UI component  to this system.
     * @param *system* the type of a system running code.
     * @param *product* the type of a ui component .
     * @return *string* .
     */
fun factory( system: MySystem, product: MyProduct): String {
    return when {
        system is MySystem.Mac && product is  MyProduct.Button -> "mac system making button"
        system is MySystem.Win && product is  MyProduct.Checkbox -> "window system making checkbox"
        else -> "nothing"
    }
}
fun main() {
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
    subject.map({ isEven(it) }).subscribe({ println("The number is ${(if (it()) "Even" else "Odd")}")})
    subject.onNext(4)
    subject.onNext(9)
    Observable.just("hello reactive world")
      .subscribe { value -> println(value)}
    println("fibo(4) is ${fibo(4)}")
    println("fiboRec(10) is ${fiboRec(10)}")
    val system = MySystem.Win
    val product = MyProduct.Checkbox
    println(factory(system, product))
    // List sealed class in ch03
    val data = Cons(1, Cons(2, Nil))
    println("data structure list ${data}")
    println(List.dropWhile(List.of(1,2,3), {x-> x==2}))
    println(List.init(List.of(1,2,3,10)))
}
