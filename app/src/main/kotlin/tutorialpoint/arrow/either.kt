package tutorialpoint.arrow

import arrow.core.Either
import arrow.core.Either.*

object NotFound
val startEither = Right("start")
fun getBusEither(demand: String): Either<NotFound,String> = 
  when(demand) {
    "" -> Right("value")
    else -> Left(NotFound)
  }
fun filterBusEither(pred: String): Either<NotFound, String> = 
  when(pred) {
    "" -> Right("value")
    else -> Left(NotFound)
  }
fun limitBusEither(limit: String): Either<NotFound, String> = 
  when(limit) {
    "" -> Right("value")
    else -> Left(NotFound)
  }

