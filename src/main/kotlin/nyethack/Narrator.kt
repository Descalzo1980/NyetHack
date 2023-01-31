package nyethack

import kotlin.random.Random
import kotlin.random.nextInt

var narrativeModifier: (String) -> String = { it }

inline fun narrate(
    message: String,
    modifier: (String) -> String = { narrativeModifier(it) }
){
    println(modifier(message))
}

fun changeNarratorMood() {
    val mood: String
    val modifier: (String) -> String
    when (Random.nextInt(1..6)) {
        1 -> {
            mood = "loud"
            modifier = { message ->
                val numExclamationPoints = 3
                message.uppercase() + "!".repeat(numExclamationPoints)
            }
        }
        2 -> {
            mood = "tired"
            modifier = { message ->
                message.lowercase().replace(" ", "... ")
            }
        }
        3 -> {
            mood = "unsure"
            modifier = { message ->
                "$message?"
            }
        }
        4 -> {
            var narrationsGiven = 0
            mood = "like sending an itemized bill"
            modifier = {it ->
                narrationsGiven++
                "$it.\n((I have narrated $narrationsGiven things)"
            }
        }
        5 -> {
            mood = "lazy like lazy"
            modifier = {message ->
                "${message.subSequence(0,40)} ...i sleep"
            }
        }
        6 -> {
            mood = "leet"
            modifier = {message ->
                message.replace(oldChar = 'l', newChar = '1', ignoreCase = true)
            }
        }
        else -> {
            mood = "professional"
            modifier = { message ->
                "$message."
            }
        }
    }
    narrativeModifier = modifier
    narrate("The narrator begins to feel $mood")
}


