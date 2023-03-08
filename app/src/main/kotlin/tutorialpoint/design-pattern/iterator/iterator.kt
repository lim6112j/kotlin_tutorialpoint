package tutorialpoint.designpattern.iterator
interface MyInterface {
  fun hasMore() : Boolean
  fun next() : Friend?
}
class Friend(val name: String, val age: Int) 
class FriendsIterator(val friends: MyFriends) : MyInterface {
  private var currentPosition = 0
  override fun hasMore(): Boolean  {
    return friends.size > currentPosition
  }
  override fun next() : Friend? {
    if(hasMore()) {
      val friend =  friends.friends[currentPosition]
      currentPosition++
      return friend
    }
    return null
  } 
}
interface Friends {
  val size: Int
  fun createFriendsIterator() : FriendsIterator
}
class MyFriends(val friends: List<Friend>,) : Friends {
  override val size = friends.size 
  override fun createFriendsIterator(): FriendsIterator {
    val iterator = FriendsIterator(this)
    return iterator
  }
}
