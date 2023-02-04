package tutorialpoint.utils
/** Executes the given [block] and returns elapsed time in milliseconds. */
public inline fun measureTimeMillis(block: () -> Unit): String {
    val start = System.currentTimeMillis()
    block()
    return "Block took time " + (System.currentTimeMillis() - start).toString() + " milliseconds"
}
