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

/*��� ���������� ��-�� ����, ��� � ������ ������ ��������
�������� name ����������� � ������ �������������, ��������� �������� name,
������� ������ � �����. �� ������ ������ name ��������������� � ����� init �
������� this.name = name, ������� ��������� ���������������� setter, ����������
� ����� ������� ������.*/
fun main(){
    val sword = Sword("Excalibur")
    println(sword.name)
}