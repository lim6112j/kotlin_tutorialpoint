package tutorialpoint.ch05

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
class Ch05Test {
    @Test fun streamTest() {
        val con = Cons({ -> 3 }, { -> Empty })
        assertNotNull(con, "stream constructor")
        assertEquals(con.headOption(), Some(3))
    }
}
