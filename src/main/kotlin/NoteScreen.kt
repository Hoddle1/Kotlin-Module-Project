class NoteScreen(private val archive: MutableList<Note>) : Screen("Заметки:") {

    init {
        addOptions("Создать заметку") { createNote() }
        addOptions("Выбрать заметку") { selectNote() }
        addOptions("Выход") { close() }
    }

    private fun createNote() {
        val noteTitle = readMessage("Введите название заметки")
        val noteContent = readMessage("Введите содержание заметки")
        archive.add(Note(noteTitle, noteContent))
        println("Заметка '$noteTitle' создана.")
    }

    private fun selectNote() {
        if (archive.isNotEmpty()) {
            val noteSelectionScreen = NoteSelectionScreen(archive)
            noteSelectionScreen.display()
        } else {
            println("Список заметок пуст.")
        }
    }

}