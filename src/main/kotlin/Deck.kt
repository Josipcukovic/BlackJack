class Deck {
    private val deck = mutableListOf<Card>()
    private val cardValues = listOf<String>("2","3","4","5","6","7","8","9","10","J","Q","K","A")
    private var numberOfCards = 52

    init {
        cardValues.forEach {
            for (i in 0..3) {
                deck.add(Card(it))
            }
        }
    }

    fun drawCard():String{
        val randomNumber = (0 until numberOfCards).random()
        numberOfCards -= 1
        val drawnCard = deck.removeAt(randomNumber)
        return drawnCard.value
    }

}