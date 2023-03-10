package tutorialpoint.designpattern.observer.fObserver

import tutorialpoint.ch03.appendR
class Subscriber(val id: Int, val name: String)
class Publisher(val id: Int, val name: String, var subscribers: Subscribers)
class Subscribers(val subs: List<Subscriber>)
public operator fun Subscribers.plus(element: Subscriber): Subscribers {
  val result = ArrayList<Subscriber>(this.subs.size + 1)
  result.addAll(this.subs)
  result.add(element)
  return Subscribers(result)
}

public operator fun Subscribers.minus(element: Subscriber): Subscribers {
  val result = ArrayList<Subscriber>(this.subs.size)
  result.addAll(this.subs)
  result.remove(element)
  return Subscribers(result)
}
fun Publisher.notify(): Unit {  
  if(this.subscribers.subs.size == 0) return
  val iter = this.subscribers.subs.iterator()
  iter.forEach({it.update()}) 
}
fun Subscriber.update(): Unit = println("${this.name} subscriber : updating ...")
fun Subscribers.add(user: Subscriber): Subscribers {
  return this + user
}

fun Subscribers.remove(user: Subscriber): Subscribers {
  return this - user
}
fun Subscriber.subscribe(publisher: Publisher): Unit {
  val newSubs = publisher.subscribers.add(this) 
  publisher.subscribers = newSubs
}

fun Subscriber.unSubscribe(publisher: Publisher): Unit {
  val newSubs = publisher.subscribers.remove(this)
  publisher.subscribers = newSubs
}
