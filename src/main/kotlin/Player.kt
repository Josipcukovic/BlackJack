open class Player{
    var points = 0
    fun calculatePoints(card: String): Int{
        when(card){
            "2"-> points += 2
            "3" -> points +=3
            "4"-> points += 4
            "5" -> points +=5
            "6"-> points += 6
            "7" -> points +=7
            "8"-> points += 8
            "9" -> points +=9
            "10"-> points += 10
            "J" -> points +=10
            "Q"-> points += 10
            "K" -> points +=10
            "A" ->{ if(points <= 10) {
                points +=11
            } else points+=1}
            else -> println("can't recognize card")
        }
        return points
    }
}