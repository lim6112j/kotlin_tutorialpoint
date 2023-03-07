package tutorialpoint.arrow

import arrow.core.Either
import arrow.core.computations.nullable
import arrow.core.flatMap

object Lettuce

object Knife

object Salad

fun takeFoodFromRefrigerator(): Lettuce? = null

fun getKnife(): Knife? = null

fun prepare(tool: Knife, ingredient: Lettuce): Salad = Salad

// fun prepareLunch(): Salad? {
//  val lettuce = takeFoodFromRefrigerator()
//  val knife = getKnife()
//  val salad = knife?.let {k -> lettuce?.let {l -> prepare(k, l)}}
//  return salad
// }
suspend fun prepareLunch(): Salad? = nullable {
    val lettuce = takeFoodFromRefrigerator().bind()
    val knife = getKnife().bind()
    val salad = prepare(knife, lettuce).bind()
    salad
}

// modeling with type -> domain modeling
sealed class Error {
    object NotANumber : Error()
    object NoZeroReciprocal : Error()
}

// 3 pure function
fun parse(s: String): Either<Error, Int> =
    when {
        s.matches(Regex("-?[0-9]+")) -> Either.Right(s.toInt())
        else -> Either.Left(Error.NotANumber)
    }

fun reciprocal(i: Int): Either<Error, Double> =
    when {
        i == 0 -> Either.Left(Error.NoZeroReciprocal)
        else -> Either.Right(1.0 / i)
    }

fun stringify(d: Double): String = d.toString()

// flatmap :: (a -> mb) -> ma -> mb, ma ~> (a -> mb) -> mb, ma -> (a -> mb) -> mb
// map :: (a -> b) -> ma -> mb
// check if, (a -> mb) -> ma -> mmb e.g. m = [], result will be [[]]
fun runChain(s: String): Either<Error, String> =
    parse(s).flatMap { reciprocal(it) }.map { x -> stringify(x) }

fun getValue(x: Either<Error, String>): String {
    val value =
        when (x) {
            is Either.Left ->
                when (x.value) {
                    is Error.NotANumber -> "Not a Number"
                    is Error.NoZeroReciprocal -> "Can't take reciprocal of 0!"
                }
            is Either.Right -> "Got reciprocal: ${x.value}"
        }
    return value
}
