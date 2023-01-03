/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tutorialpoint

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertFails
import tutorialpoint.ch02.*
class AppTest {
    @Test fun appHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
    @Test fun isSorted() {
        assert(isSorted(listOf(3,2,1), order))
    }
    @Test fun isSorted2() {
        assert(!isSorted(listOf(3,2,1,11), order))
    }
    @Test fun isSortedTailrec() {
        assert(isSortedRec(listOf(3,2,1), order))
    }
    @Test fun isSortedTailrec2() {
        assert(!isSortedRec(listOf(2,2,1), order))
    }
}
