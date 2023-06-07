package OOP.Java.lab_5

/**
 * A class representing a single letter in a word.
 *
 * @property character a character value of a Letter.
 */
class Letter(private val character: Char) {
    override fun toString(): String {
        return this.character.toString()
    }

    /**
     * Indicates whether the two objects of class Letter are "equal".
     *
     * @param letter a letter to compare.
     * @param ignoreCase if set to "true" will ignore the case of Letters compared.
     * @return "true" if letters are equal and "false" if they aren't.
     */
    fun letterEquals(letter: Letter, ignoreCase: Boolean): Boolean {
        return this.character.toString().equals(letter.toString(), ignoreCase)
    }
}