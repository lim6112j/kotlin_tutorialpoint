package tutorialpoint.designpattern.fIterator
// type
data class FFriend(val name: String, val age: Int)
class FFriends(val friends: List<FFriend>, var currentIdx: Int = 0)
// pure function
fun FFriends.hasMore(): Boolean = this.friends.size > currentIdx
fun FFriends.next(): FFriend? {
  if(this.hasMore()) {
    val currentFriend = this.friends[this.currentIdx]
    this.currentIdx++
    return currentFriend
  }
  return null;
}



