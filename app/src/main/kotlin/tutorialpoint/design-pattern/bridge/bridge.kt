package tutorialpoint.designpattern.bridge

interface Shape {
  val color:Color
}
class Circle(override val color: Color): Shape
class Rectangle(override val color: Color): Shape

interface Color {
  fun getColor(): String
}
object Red: Color {
  override fun getColor(): String = "red"
}
object Blue: Color{
  override fun getColor(): String = "blue"
}


