package tutorialpoint.designpattern.observer
interface OOPSubscriber {
  val name: String
  val id: Int
  fun update(): Unit
  fun subscribe(publisher: OOPPublisher): Unit
}
interface OOPPublisher {
  val name: String
  val id: Int
  var subscribers: List<OOPSubscriber>
  fun notifySub(): Unit
}
class NewsSubscriber( val n: String,  val i: Int) : OOPSubscriber {
  override val name = n
  override val id = i
  override fun update(): Unit = TODO()
  override fun subscribe(publisher:OOPPublisher): Unit = TODO()
}
class NewsPublisher(val n:String, val i:Int, var subs: List<OOPSubscriber>) : OOPPublisher {
  override val name = n
  override val id = i
  override var subscribers = subs
  override fun notifySub(): Unit = TODO()
}
