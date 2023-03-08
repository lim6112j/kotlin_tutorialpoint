package tutorialpoint.designpattern.fIterator
data class FFriend(val name: String, val age: Int)
class FFriends(val friends: List<FFriend>, var currentIdx: Int = 0)
fun FFriends.hasMore(): Boolean = this.friends.size > currentIdx
fun FFriends.next(): FFriend? {
  if(this.hasMore()) {
    val currentFriend = this.friends[this.currentIdx]
    this.currentIdx++
    return currentFriend
  }
  return null;
}



