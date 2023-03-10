package tutorialpoint.designpattern.state

sealed class State 
object Ready: State()
object Go: State()
object Stop: State()

sealed class Action
object Do: Action()
object Cancel: Action()

fun Pair<State,String>.machine(action: Action): Pair<State, String> =
  when(this.first) {
    is Ready -> when(action) { 
      is Do -> Go to this.second + "\nready -> go"
      is Cancel -> Stop to this.second + "\nready canceled"}
    is Go -> when(action) { 
      is Do -> Go to this.second + "\ngo go "
      is Cancel -> Stop to this.second + "\ngo canceled"
    }
    is Stop -> when(action) {
      is Do -> Stop to this.second + "\nstop do"
      is Cancel -> Ready to this.second + "\nstop canceled"
    }
  }

