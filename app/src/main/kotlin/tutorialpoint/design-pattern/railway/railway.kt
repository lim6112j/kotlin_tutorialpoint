package tutorialpoint.designpattern.railway

import arrow.core.Option
import arrow.core.Some
import arrow.core.None
val startVal = Some("1")
fun searchBus(demand: String): Option<String> = 
  when(demand) {
    "1" -> Some("value")
    else -> None
  }
fun filterBus(arg: String): Option<String> = 
  when(arg.length) {
    0 -> None
    else -> Some("Buses") 
  }
fun limitBus(arg: String): Option<String> = 
  when(arg.length) {
    0 -> None
    else -> Some("value")
  }


