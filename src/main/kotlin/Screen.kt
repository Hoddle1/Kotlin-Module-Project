import java.util.Scanner

abstract class Screen(private val titleMenu: String) {
    private val options = mutableListOf<Pair<String, () -> Unit>>()

    fun addOptions(optionName: String, action: () -> Unit) {
        options.add(Pair(optionName, action))
    }

    private fun printOptions() {
        println("\n$titleMenu")
        options.forEachIndexed { index, (option, _) ->
            println("${index + 1}. $option")
        }
    }

    private fun readIndexMenu(): Int {
        val sc = Scanner(System.`in`)
        while (true) {
            try {
                val index = sc.nextLine().trim().toInt()
                if (index > 0 && index <= options.size) {
                    return index
                } else {
                    println("Неверный номер. Попробуйте снова.")
                }
            } catch (e: NumberFormatException) {
                println("Ввод должен быть числом.")
            }
        }
    }

    fun display() {
        while (true) {
            printOptions()
            val index = readIndexMenu()
            if (index == options.size) {
                return
            }
            options[index - 1].second.invoke()
        }
    }

    fun readMessage(title: String): String {
        val sc = Scanner(System.`in`)
        while (true) {
            println(title)
            val name = sc.nextLine().trim()
            if (name.isNotEmpty()) {
                return name
            } else {
                println("Поле не может быть пустым.")
            }
        }
    }

    fun close() {}

}