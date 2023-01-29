import java.io.File

fun main(){
    val menuData = File("data/tavern-menu-data.txt")
        .readText()
        .split("\n")

    println("*** Welcome to Taernyl's Folly ***\n")
    menuData.forEach{
        val (group, name, price) = it.split(",")
        val lengthMenu = 50
        val result = lengthMenu - (name.length + price.length)
        println("${name.replaceFirstChar{ it.uppercase()}} ${".".repeat(result)}$price")
    }
}




