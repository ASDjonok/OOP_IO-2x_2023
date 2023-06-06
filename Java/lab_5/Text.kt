package OOP.Java.lab_5

class Text(textString: String) {
    var textArray = Pair(splitSentences(textString), splitPunctuation(textString))

    private fun splitSentences(textString: String): Array<Sentence> {
        return textString.split("[.!?] ?".toRegex()).filter { it.isNotEmpty() }.map { sentence -> Sentence(sentence) }.toTypedArray()
    }

    private fun splitPunctuation(textString: String): Array<Punctuation> {
        return textString.split("(?<=[.!?]) ?".toRegex()).filter { it.isNotEmpty() }.map { sentence -> Punctuation(sentence.last().toString()) }.toTypedArray()
    }

    fun getAllLetters(): Array<Letter> {
        var allLetters = arrayOf<Letter>()
        this.textArray.first.forEach { allLetters += it.getAllLetters() }
        return allLetters
    }

    fun palindromeSearch(): String {
        var results = arrayOf<String>()
        val letters = this.getAllLetters()
        for (leftBoundary in letters.indices) {
            for (rightBoundary in letters.lastIndex downTo leftBoundary + 1) {
                val subToC = letters.sliceArray(leftBoundary..rightBoundary)
//                println(subToC.joinToString(""))

                if (subToC.first().equals(subToC.last(), true) && subToC.size >= 3 && this.checkReverse(subToC)) {
//                    println(subToC.joinToString(""))
                    results += subToC.joinToString("")
                }
            }
        }
        return results.maxBy { it.length }
    }

    private fun checkReverse(substring: Array<Letter>): Boolean {
        var leftBoundary = 0
        var rightBoundary = substring.lastIndex
        var result = false
        var correction = 0

        if (substring.size % 2 != 0) {
            correction = 1
        }

        while (leftBoundary < substring.size / 2 && rightBoundary >= substring.size / 2 + correction) {
            leftBoundary++
            rightBoundary--
            result = substring[leftBoundary].equals(substring[rightBoundary], true)
        }

        return result
    }


    override fun toString(): String {
        var text = arrayOf<String>()
        for (i in this.textArray.first.indices) {
            text += this.textArray.first[i].toString() + this.textArray.second[i].toString()
        }
        return text.joinToString(" ")
    }
}