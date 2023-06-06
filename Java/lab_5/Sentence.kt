package OOP.Java.lab_5

class Sentence(sentenceString: String) {
    var sentenceArray = Pair<Array<Word>, Array<Punctuation>>(splitWords(sentenceString), splitPunctuation(sentenceString))

    init {
//        val arrayOfWords: Array<Word> = splitWords(sentenceString)
//        val arrayOfPunctuations: Array<Punctuation> = splitPunctuation(sentenceString)

    }

    private fun splitWords(sentenceString: String): Array<Word> {
        return sentenceString.split("[\\p{Punct}\\s]+".toRegex()).filter { it.isNotEmpty() }.map { word -> Word(word) }.toTypedArray()
    }

    private fun splitPunctuation(sentenceString: String): Array<Punctuation> {
        return sentenceString.split(" ").map { word -> Punctuation(word.last().toString()) }.toTypedArray()
    }

    fun getAllLetters(): Array<Letter> {
        var allLetters = arrayOf<Letter>()
        this.sentenceArray.first.forEach { allLetters += it.letters }
        /*for (i: Word in this.sentenceArray.first) {
            println("${i} ${i::class.simpleName} ${i.letters}")
        }*/
        return allLetters
    }

    override fun toString(): String {
        var sentence = arrayOf<String>()
        for (i in this.sentenceArray.first.indices) {
            sentence += this.sentenceArray.first[i].toString() + this.sentenceArray.second[i].toString()
        }
        return sentence.joinToString(" ")
    }
}