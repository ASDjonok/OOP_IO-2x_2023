package OOP.Java.lab_5

/**
 * A class representing a single sentence is a text.
 *
 * @property sentenceArray a [Pair] of [Array]s of [Word] and [Punctuation] objects that make up a sentence.
 *
 * @constructor a primary constructor accepts a [Pair] of [Array]s of [Word] and [Punctuation] objects, a secondary one accepts a string representing the entire sentence.
 */
class Sentence(var sentenceArray: Pair<Array<Word>, Array<Punctuation>>) {

    constructor(
        sentenceString: String
    ) : this(
        Pair(
            sentenceString.split("[\\p{Punct}\\s]+".toRegex()).filter { it.isNotEmpty() }.map { word -> Word(word) }.toTypedArray(),
            sentenceString.split(" ").map { word -> Punctuation(word.last().toString()) }.toTypedArray()
        )
    )

    /**
     * Returns an array of all [Letter] objects in a sentence.
     */
    fun getAllLetters(): Array<Letter> {
        var allLetters = arrayOf<Letter>()
        this.sentenceArray.first.forEach { allLetters += it.letters }
        return allLetters
    }

    override fun toString(): String {
        var sentence = arrayOf<String>()
        this.sentenceArray.first.indices.forEach {sentence += this.sentenceArray.first[it].toString() + this.sentenceArray.second[it].toString() }
        return sentence.joinToString(" ")
    }
}