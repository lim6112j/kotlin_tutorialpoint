package tutorialpoint.ch06
interface RNG {
    fun nextInt(): Pair<Int, RNG>
}
data class SimpleRNG(val seed: Long) : RNG {
    override fun nextInt(): Pair<Int, RNG> {
        val newSeed =
            (seed * 0x5DEECE66DL + 0xBL) and 0xFFFFFFFFFFFFL
        val nextRNG = SimpleRNG(newSeed)
        val n = (newSeed ushr 16).toInt()
        return n to nextRNG
    }
}

// exe; 6.2
fun double(rng: RNG): Pair<Double, RNG> {
    val (n, newRNG) = rng.nextInt()
    val doubleVal: Double = n.toDouble() / Int.MAX_VALUE
    return doubleVal to newRNG
}
