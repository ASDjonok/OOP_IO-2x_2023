package OOP.Java.lab_5

class Punctuation(var punctuationMark: String) {
    private val punctuationMarkOptions: Regex = Regex("\\p{Punct}")

    init {
        if (!punctuationMarkOptions.containsMatchIn(punctuationMark)){
            this.punctuationMark = ""
        }
    }
}