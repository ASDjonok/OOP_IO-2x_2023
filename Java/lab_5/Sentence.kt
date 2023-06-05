package OOP.Java.lab_5

class Sentence(sentenceString: String) {
    init {
        var split = sentenceString.split("(\\p{Punct}? )|(\\p{Punct})".toRegex())
        var punctuation: Array<Punctuation> = sentenceString.split(" ").map { word -> Punctuation(word.last().toString()) }.toTypedArray()
        for (elem in split) {
            println(elem)
        }
        print(split)
    }
}