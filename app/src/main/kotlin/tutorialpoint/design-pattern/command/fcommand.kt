package tutorialpoint.designpattern.command
sealed class UIComponent
object Button:UIComponent()
object Shortcut: UIComponent()
object Menu: UIComponent()

sealed class Command
object CopyCommand: Command()
object PasteCommand: Command()
object CutCommand: Command()

data class Invoker(val queue: List<Pair<UIComponent, Command>>)

fun Invoker.execute(component: UIComponent, command: Command): Invoker = 
  this.addCommandToQueue(component, command)
fun Invoker.addCommandToQueue(component: UIComponent, command: Command): Invoker {
  val aQueue = component to command
  val newQueue = this.queue + aQueue
  return Invoker(newQueue)
  }
fun Invoker.invoke(): Unit {
  this.queue.iterator().forEach { println(it) }
}


