package tutorialpoint.ch03

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertFails
import kotlin.test.assertEquals
import tutorialpoint.ch03.*
class Ch03Test {
  @Test fun listtest() {
    assertEquals(List.sum(List.of(1,2,3)),6)
    assertEquals(List.product(List.of(1.0,2.0,3.0)), 6.0)
  }
}
