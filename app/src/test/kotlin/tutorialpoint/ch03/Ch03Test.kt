package tutorialpoint.ch03

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertFails
import kotlin.test.assertEquals
import tutorialpoint.ch03.*
class Ch03Test {
  @Test fun listOfTest() {
    assertEquals(List.sum(List.of(1,2,3)),6)
    assertEquals(List.product(List.of(1.0,2.0,3.0)), 6.0)
  }
  @Test fun tailTest() {
    assertEquals(List.tail(List.of(1,2,3)), List.of(2,3))
  }
  @Test fun setHeadTest() {
    assertEquals(List.setHead(List.of(1,2,3), 0), List.of(0,1,2,3))
    assertEquals(List.setHead(Nil, 0), List.of(0))
    assertEquals(List.setHead(Nil, Nil), Nil)
    assertEquals(List.setHead(List.of(1,2,3), Nil), List.of(1,2,3))
  }
  @Test fun dropTest() {
    assertEquals(List.drop(List.of(1,2,3), 1), List.of(2,3))
    assertEquals(List.drop(List.of(1,2,3), 3), Nil)
    assertEquals(List.drop(List.of(1,2,3), 0), List.of(1,2,3))
    assertEquals(List.drop(Nil, 3), Nil)
    assertEquals(List.drop(Nil, 0), Nil)
  }
  @Test fun dropWhileTest() {
    assertEquals(List.dropWhile(List.of(1,2,3), {x -> x==2}), List.of(3))
    assertEquals(List.dropWhile(List.of(1,2,3), {x -> x==3}), Nil)
    assertEquals(List.dropWhile(List.of(1,2,3), {x -> x==4}), Nil)
    assertEquals(List.dropWhile(Nil, {x -> x==4}), Nil)
    assertEquals(List.dropWhile(List.of(1,2,3), {x -> x==0}), Nil)
  }
}
