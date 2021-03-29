class Game {
    private val deck = Deck()
    private val player = Player()
    private val dealer = Dealer()
    private var flag = 0
    private var playerCard: String = ""
    private var dealersSecondCard = ""

    private fun firstRound(){
        dealer.facedDownCard = deck.drawCard()
        dealersSecondCard = deck.drawCard()
        println("Dealer card: $dealersSecondCard")
        println("-------------------------------------")
        println("Your cards:")
        for(i in 0..1) {
            playerCard = deck.drawCard()
            println(playerCard)
            player.calculatePoints(playerCard)
        }
    }

    private fun isOver21(): Boolean {
        if(player.points > 21) {
            flag = 1
            return true
        }
        return false
    }

   private fun playerDrawCards(){
            playerCard = deck.drawCard()
            println("Card is: $playerCard")
            println("You have ${player.calculatePoints(playerCard)} points")
            println("Do you want another card?(y/n)")
    }

    private fun showDealerCards(){
        dealer.calculatePoints(dealer.facedDownCard)
        dealer.calculatePoints(dealersSecondCard)
        println("Dealer cards: ${dealer.facedDownCard}, $dealersSecondCard")
    }

    private fun dealerDrawCards(){
            val drawnCard = deck.drawCard()
            dealer.calculatePoints(drawnCard)
            println("Dealer has drawn $drawnCard")
    }

    private fun comparePoints(){
        if ((dealer.points < player.points)  || dealer.points > 21) {
            println("Your points: ${player.points}, Dealer points: ${dealer.points}")
            println("You won!!")
        } else if (player.points == dealer.points) {
            println("Draw")
        }else{
            println("Your points: ${player.points}, Dealer points: ${dealer.points}")
            println("you lost")
        }
    }

    fun startGame(){
        firstRound()
        println("You have ${player.points} points")
        println("Do you want another card?(y/n)")
        while (readLine() =="y") {
            playerDrawCards()
            if(isOver21()) break
        }
        if(flag==0){
            showDealerCards()
            while (dealer.points<=16) {
                dealerDrawCards()
            }
            println("Dealer has ${dealer.points} points")
        }
        if(flag==0) comparePoints() else println("You lost")
    }

}