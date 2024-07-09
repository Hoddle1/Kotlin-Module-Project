class ArchiveScreen : Screen("Архивы:") {
    private val archives = mutableMapOf<String, MutableList<Note>>()

    init {
        addOptions("Создать архив") { addArchive() }
        addOptions("Выбрать архив") { selectArchive() }
        addOptions("Выход") { close() }
    }

    private fun addArchive() {
        val archiveName = readMessage("Введите название архива")
        archives[archiveName] = mutableListOf()
        println("Архив '$archiveName' создан.")
    }

    private fun selectArchive() {
        if (archives.isNotEmpty()) {
            val archiveSelectionScreen = ArchiveSelectionScreen(archives)
            archiveSelectionScreen.display()
        } else {
            println("Список архивов пуст.")
        }
    }


}