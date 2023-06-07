package OOP.Java.lab_5

/**
 * A class representing the entire text.
 *
 * @property textArray a [Pair] of [Array]s of [Sentence] and [Punctuation] objects that make up a text.
 *
 * @constructor a primary constructor accepts a [Pair] of [Array]s of [Sentence] and [Punctuation] objects, a secondary one accepts a string representing the entire text.
 */
class Text(var textArray: Pair<Array<Sentence>, Array<Punctuation>>) {

    constructor(
        textString: String
    ) : this(
        Pair(
            textString.split("[.!?] ?".toRegex()).filter { it.isNotEmpty() }.map { sentence -> Sentence(sentence) }.toTypedArray(),
            textString.split("(?<=[.!?]) ?".toRegex()).filter { it.isNotEmpty() }.map { sentence -> Punctuation(sentence.last().toString()) }.toTypedArray()
        )
    )

    /**
     * Returns an array of all [Letter] objects in a sentence.
     */
    private fun getAllLetters(): Array<Letter> {
        var allLetters = arrayOf<Letter>()
        this.textArray.first.forEach { allLetters += it.getAllLetters() }
        return allLetters
    }

    /**
     * Searches for the longest palindromic substring in a given text.
     *
     * @return the longest palindromic substring found.
     */
    fun palindromeSearch(): String {
        var result = "  "

        val letters = this.getAllLetters()

        for (leftBoundary in letters.indices) {
            for (rightBoundary in letters.lastIndex downTo leftBoundary + 1) {
                val subToC = letters.sliceArray(leftBoundary..rightBoundary)

                if (subToC.first().letterEquals(subToC.last(), true) && this.checkReverse(subToC) && subToC.size > result.length) {
                    result = subToC.joinToString("")
                }
            }
        }

        return result
    }

    /**
     * Checks if a given substring is a palindrome.
     *
     * Is not case-sensitive.
     *
     * @param substring an [Array] of [Letter] objects representing a substring.
     *
     * @return "true" is a substring given is a palindrome, "false" if it isn't.
     */
    private fun checkReverse(substring: Array<Letter>): Boolean {
        var leftBoundary = 0
        var rightBoundary = substring.lastIndex
        var result = false
        val correction = substring.size % 2

        while (leftBoundary < substring.size / 2 && rightBoundary >= substring.size / 2 + correction) {
            leftBoundary++
            rightBoundary--
            result = substring[leftBoundary].letterEquals(substring[rightBoundary], true)
        }

        return result
    }


    override fun toString(): String {
        var text = arrayOf<String>()
        this.textArray.first.indices.forEach { text += this.textArray.first[it].toString() + this.textArray.second[it].toString() }
        return text.joinToString(" ")
    }
}