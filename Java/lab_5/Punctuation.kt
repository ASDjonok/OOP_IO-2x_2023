package OOP.Java.lab_5

/**
 * A class representing a punctuation mark following a word or a sentence.
 *
 * @property punctuationMark a [String] value of a punctuation mark.
 */
class Punctuation(var punctuationMark: String) {

    init {
        if (!"\\p{Punct}".toRegex().containsMatchIn(punctuationMark)) {
            this.punctuationMark = ""
        }
    }

    override fun toString(): String {
        return punctuationMark
    }
}