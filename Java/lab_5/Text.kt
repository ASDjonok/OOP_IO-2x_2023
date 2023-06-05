package OOP.Java.lab_5

class Text(textString: String) {
    var textArray = arrayOf<Pair<Sentence, Punctuation>>()
    var rawText: String = ""

    init {
        val arrayOfSentences = splitSentences(textString)
        val arrayOfPunctuations: Array<Punctuation> = splitPunctuation(textString)

        for (i in arrayOfSentences.indices){
            textArray += Pair(arrayOfSentences[i], arrayOfPunctuations[i])
        }

        this.rawText = getRawTextString(arrayOfSentences)
    }

    private fun splitSentences(textString: String): Array<Sentence> {
        return textString.split("[.!?] ?".toRegex()).filter { it.isNotEmpty() }.map { sentence -> Sentence(sentence) }.toTypedArray()
    }

    private fun splitPunctuation(textString: String): Array<Punctuation>{
        return textString.split("(?<=[.!?]) ?".toRegex()).filter { it.isNotEmpty() }.map { sentence -> Punctuation(sentence.last().toString()) }.toTypedArray()
    }

    private fun getRawTextString(arrayOfSentences: Array<Sentence>): String {
        return arrayOfSentences.joinToString("") { sentence -> sentence.arrayOfWords.joinToString("") }
    }

    override fun toString(): String {
        var text = arrayOf<String>()
        this.textArray.forEach { text += it.first.toString() + it.second.toString() }
        return text.joinToString(" ")
    }
}