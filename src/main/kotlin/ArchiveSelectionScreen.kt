class ArchiveSelectionScreen(
    private val archives: MutableMap<String, MutableList<Note>>
) : Screen("Список архивов:") {
    init {
        archives.forEach { archive ->
            addOptions(archive.key) { selectArchive(archive.key) }
        }
        addOptions("Выход") { close() }
    }

    private fun selectArchive(archiveName: String) {
        val noteScreen = NoteScreen(archives[archiveName]!!)
        noteScreen.display()
    }
}