package OOP.Java.lab_5

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