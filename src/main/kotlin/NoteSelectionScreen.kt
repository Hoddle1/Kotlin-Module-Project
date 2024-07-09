import java.util.Scanner

class NoteSelectionScreen(archive: MutableList<Note>) : Screen("Список заметок:") {
    init {
        archive.forEach { note ->
            addOptions(note.title) { selectNote(note) }
        }
        addOptions("Выход"){ close() }
    }

    private fun selectNote(note: Note) {
        println(note)
        println("Нажмите Enter для возврата.")
        Scanner(System.`in`).nextLine()
    }


}
