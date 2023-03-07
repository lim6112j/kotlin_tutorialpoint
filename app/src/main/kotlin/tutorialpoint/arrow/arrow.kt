package tutorialpoint.arrow
import arrow.core.computations.nullable
import tutorialpoint.arrow.takeFoodFromRefrigerator
import tutorialpoint.arrow.getKnife
object Lettuce
object Knife
object Salad
fun takeFoodFromRefrigerator(): Lettuce? = null
fun getKnife(): Knife? = null
fun prepare(tool: Knife, ingredient: Lettuce): Salad = Salad
fun prepareLunch(): Salad? {
  val lettuce = takeFoodFromRefrigerator()
  val knife = getKnife()
  val salad = knife?.let {k -> lettuce?.let {l -> prepare(k, l)}}
  return salad
}
