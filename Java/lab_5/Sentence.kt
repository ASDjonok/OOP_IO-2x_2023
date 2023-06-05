package OOP.Java.lab_5

class Sentence(sentenceString: String) {
    var sentenceArray = arrayOf<Pair<Word, Punctuation>>()
    val arrayOfWords: Array<Word> = splitWords(sentenceString)
    val arrayOfPunctuations: Array<Punctuation> = splitPunctuation(sentenceString)

    init {
//        val arrayOfWords: Array<Word> = splitWords(sentenceString)
//        val arrayOfPunctuations: Array<Punctuation> = splitPunctuation(sentenceString)


        for (i in arrayOfWords.indices) {
            sentenceArray += Pair(arrayOfWords[i], arrayOfPunctuations[i])
        }
    }

    private fun splitWords(sentenceString: String): Array<Word>{
        return sentenceString.split("[\\p{Punct}\\s]+".toRegex()).filter { it.isNotEmpty() }.map { word -> Word(word) }.toTypedArray()
    }

    private fun splitPunctuation(sentenceString: String): Array<Punctuation>{
        return sentenceString.split(" ").map { word -> Punctuation(word.last().toString()) }.toTypedArray()
    }

    override fun toString(): String {
        var sentence = arrayOf<String>()
        this.sentenceArray.forEach { sentence += it.first.toString() + it.second.toString() }
        return sentence.joinToString(" ")
    }
}