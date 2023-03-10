interface Subscriber {
  fun update(): Unit
  fun subscribe(): Unit
}
interface Publisher {
  var subscribers: List<Subscriber>
  fun notify(): Unit
}
class NewsSubscriber : Subscriber {
  override fun update(): Unit = TODO()
  override fun subscribe(): Unit = TODO()
}
class NewsPublisher(var subs: List<Subscriber>) : Publisher {
  override var subscribers = subs
  override fun notify(): Unit = TODO()
}
