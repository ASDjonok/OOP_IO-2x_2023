package OOP.Java.lab_5

/**
 * A class representing a single word is a sentence.
 *
 * @property letters an array of [Letter] objects that make up a word.
 *
 * @constructor a primary constructor accepts an array of [Letter] objects, a secondary one accepts a string representing the entire word.
 */
class Word(var letters: Array<Letter>) {

    override fun toString(): String {
        val wordString = StringBuilder()
        this.letters.forEach { wordString.append(it) }

        return wordString.toString()
    }

    constructor(
        word: String
    ) : this((word.toCharArray().map { letter -> Letter(letter) }).toTypedArray())
}