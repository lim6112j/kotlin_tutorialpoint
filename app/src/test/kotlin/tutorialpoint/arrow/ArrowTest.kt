package tutorialpoint.arrow

import kotlin.test.Test
import kotlin.test.assertEquals

class ArrowTest {
    @Test
    fun runchainTest() {
        val x = runChain("2")
        assertEquals(getValue(x), "Got reciprocal: 0.5")
        val y = runChain("0")
        assertEquals(getValue(y), "Can't take reciprocal of 0!")
    }
}
