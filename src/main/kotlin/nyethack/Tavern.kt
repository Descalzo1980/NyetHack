package nyethack

import java.io.File

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"

private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames = setOf("Ironfoot", "Fernsworth", "Baggins", "Downstrider")

private val menuData = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")


private val menuItems = menuData.map { menuEntry  ->
    val (_, name, _) = menuEntry.split(",")
    name
}

private val menuItemPrices = menuData.associate { menuEntry ->
    val (_, name, price) = menuEntry.split(",")
    name to price.toDouble()
}

private val menuItemTypes = menuData.associate { menuEntry ->
    val (type, name, _) = menuEntry.split(",")
    name to type
}


fun visitTavern(){
    narrate("${player.name} enters $TAVERN_NAME")
    narrate("There are several items for sale:")
    narrate(menuItems.joinToString())
    val patrons: MutableSet<String> = mutableSetOf()
    val patronGold = mutableMapOf(
        "Taernyl" to 86.00,
        player.name to 4.50
    )
    while (patrons.size < 5){
        val patronName = "${firstNames.random()} ${lastNames.random()}"
        patrons += patronName
        patronGold += patronName to 6.0
    }
    println(patronGold)
    narrate("${player.name} sees several patrons in the tavern: ")
    narrate(patrons.joinToString())
    repeat(3){
        placeOrder(patrons.random(), menuItems.random(),patronGold)
    }
    displayPatronBalances(patronGold)
}

private fun placeOrder(
    patronName: String,
    menuItemName: String,
    patronGold: MutableMap<String, Double>
){
    val itemPrice = menuItemPrices.getValue(menuItemName)
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    if (itemPrice <= patronGold.getOrDefault(patronName, 0.0)) {
        val action = when (menuItemTypes[menuItemName]) {
            "shandy", "elixir" -> "pours"
            "meal" -> "serves"
            else -> "hands"
        }
        narrate("$TAVERN_MASTER $action $patronName a $menuItemName")
        patronGold[patronName] = patronGold.getValue(patronName) - itemPrice
        patronGold[TAVERN_MASTER] = patronGold.getValue(TAVERN_MASTER) + itemPrice
    } else {
        narrate("$TAVERN_MASTER says, \"You need more coin for a $menuItemName\"")
    }
        narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
}

private fun displayPatronBalances(patronGold: Map<String, Double>) {
    narrate("${player.name} intuitively knows how much money each patron has")
    patronGold.forEach { (patron, balance) ->
        narrate("$patron has ${"%.2f".format(balance)} gold")
    }
}
