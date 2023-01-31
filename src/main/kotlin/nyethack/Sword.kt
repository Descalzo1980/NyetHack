package nyethack

import java.util.*

class Sword(name: String) {
    var name = name
        get() = "The Legendary $field"
        set(value) {
            field = value.lowercase().reversed()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
    init {
        this.name = name
    }

}

/*Это происходит из-за того, что в первом случае значение
свойства name назначается в момент инициализации, используя параметр name,
который входит в класс. Во втором случае name переназначается в блоке init с
помощью this.name = name, который применяет переопределенный setter, инвертируя
и меняя регистр строки.*/
fun main(){
    val sword = Sword("Excalibur")
    println(sword.name)
}