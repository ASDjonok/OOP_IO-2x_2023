package OOP.Java.lab_5

class Letter(val character: Char) {
    override fun toString(): String {
        return this.character.toString()
    }

    fun equals(letter: Letter, ignoreCase: Boolean): Boolean {
        return this.character.toString().equals(letter.toString(), ignoreCase)
    }
}