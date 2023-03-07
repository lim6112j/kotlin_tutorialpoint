package tutorialpoint.arrow
import arrow.core.computations.nullable
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
suspend fun prepareLunch(): Salad? =
    nullable {
        val lettuce = takeFoodFromRefrigerator().bind()
        val knife = getKnife().bind()
        val salad = prepare(knife, lettuce).bind()
        salad
    }
