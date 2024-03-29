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
  @Test fun initTest() {
    assertEquals(List.init(List.of(1,2,3,4)), List.of(1,2,3))
    assertEquals(List.init(List.of(1)), Nil)
    assertEquals(List.init(Nil), Nil)
  }
  @Test fun foldTest() {
    assertEquals(List.foldRight(List.of(1,2,3,4,5,6,7,8,9,10), 0, {x,y -> x + y}), 55)
    assertEquals(List.foldRight(List.of(1,2,3,4,5,6,7,8,9,10), 1, {x,y -> x * y}), 3628800)
    assertEquals(List.foldLeft(List.of(1,2,3,4,5,6,7,8,9,10), 0, {x,y -> x + y}), 55)
  }
  @Test fun lengthTest() {
    assertEquals(length(List.of(1,2,3)), 3)
    assertEquals(length(Nil), 0)
    assertEquals(length(List.of(1)), 1)
  }
  @Test fun foldLeftTest() {
    assertEquals(foldSum(List.of(1,2,3)), 6)
    assertEquals(foldProduct(List.of(1.0,2.0,3.0,4.0)), 24.0)
    assertEquals(foldLengh(List.of(1,2,3)), 3)
    assertEquals(foldLengh(List.of(1)), 1)
    assertEquals(foldLengh(Nil), 0)
  }
  @Test fun reverseTest() {
    assertEquals(List.append(List.of(1,2,3), List.of(3,2,1)), List.of(1,2,3,3,2,1))
  }
  @Test fun foldRWithFoldLTest () {
    assertEquals(foldRWithFoldL(List.of(1,2,3), 0 ,{ x,y -> x + y }), 6)
  }
  @Test fun appendTest() {
    assertEquals(appendR(List.of(1,2,3), List.of(1,2,3)), List.of(1,2,3,1,2,3))
  }
  @Test fun listToString() {
    assertEquals(listToString(List.of(1.0,2.0,3.0)), List.of("1.0","2.0","3.0"))
  }
  @Test fun mapTest() {
    assertEquals(map(List.of(1,2,3), {x -> x * 2}), List.of(2,4,6))
  }
  @Test fun filterTest() {
    assertEquals(filter(List.of(1,2,3,4,5,6), {x -> x % 2 == 0}), List.of(2,4,6))
    assertEquals(filter(List.of(1,2,3,4,5,6), {x -> x % 3 == 0}), List.of(3,6))
    assertEquals(filter(Nil as List<Int>, {x -> x % 3 == 0}), Nil)
  }
  @Test fun flatMapTest() {
    assertEquals(flatMap(List.of(1,2,3), {x -> List.of(x,x)}), List.of(1,1,2,2,3,3))
  }
  @Test fun filter2Test() {
    assertEquals(filter2(List.of(1,2,3,4,5,6), {x -> x % 2 == 0}), List.of(2,4,6))
    assertEquals(filter2(List.of(1,2,3,4,5,6), {x -> x % 3 == 0}), List.of(3,6))
  }
  }
