private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"


fun visitTavern(){
     narrate("$heroName enters $TAVERN_NAME")
    val patrons= mutableListOf("Eli", "Mordoc", "Sophie")
    val eliMaster = if(patrons.contains("Eli")){
        "$TAVERN_MASTER says: Eli's in the back playing cards"
    }else{
        "$TAVERN_MASTER says: Eli isn't here"
    }
    println(eliMaster)
    val othersMessage = if (patrons.containsAll(listOf("Sophie", "Mordoc"))) {
        "$TAVERN_MASTER says: Sophie and Mordoc are seated by the stew kettle"
    } else {
        "$TAVERN_MASTER says: Sophie and Mordoc aren't with each other right now"
    }
    println(othersMessage)
    patrons.forEachIndexed { index, patron ->
        println("Good evening, $patron - yoy are #${index + 1}")
    }
}