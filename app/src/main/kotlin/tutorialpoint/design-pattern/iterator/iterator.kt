package tutorialpoint.designpattern.iterator
interface MyIterator {
  fun hasMore() : Boolean
  fun next() : Friend?
}
interface Friends {
  val size: Int
  fun createFriendsIterator() : MyIterator
}
class Friend(val name: String, val age: Int) 
class FriendsIterator(val friends: MyFriends) : MyIterator {
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
class MyFriends(val friends: List<Friend>,) : Friends {
  override val size = friends.size 
  override fun createFriendsIterator(): FriendsIterator {
    val iterator = FriendsIterator(this)
    return iterator
  }
}
