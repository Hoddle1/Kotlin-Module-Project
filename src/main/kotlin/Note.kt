data class Note(
    val title: String,
    val content: String
){
    override fun toString(): String {
        return """
            
            Название заметки: $title
            Содержание: $content
        """.trimIndent()
    }
}