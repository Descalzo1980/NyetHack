package nyethack
//val player = Player("Jason")
lateinit var player: Player

fun main() {
    narrate("Welcome to NyetHack!")
    val playerName = promptHeroName()
    player = Player(playerName)
    // nyethack.changeNarratorMood()
    player.prophesize()
    val mortality = if(player.isImmortal)  "an immortal" else "a mortal"
    narrate("${player.name} of ${player.homeTown}, ${player.title}, heads to the town square")
    narrate("${player.name}, $mortality, has ${player.healthPoints} health points")
    visitTavern()
    player.castFireball()
    player.prophesize()
}

private fun makeYellow(message: String) = "\u001b[33;1m$message\u001b[0m"

private fun promptHeroName(): String{
    narrate("A hero enters the town of Kronstadt. What is their name?") {message ->
        makeYellow(message = message)
    }
    println("Madrigal")
    return "Madrigal"
}
