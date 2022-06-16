package id.com.zulfikar.jankengame.game

class Player(private var name: String) {
  var handId: Int = 0
  lateinit var hand: String
  
  private fun getHandName(): String {
    val handName = when (handId) {
      1 -> "Rock"
      2 -> "Paper"
      3 -> "Scissor"
      else -> "None"
    }
    return handName
  }
}