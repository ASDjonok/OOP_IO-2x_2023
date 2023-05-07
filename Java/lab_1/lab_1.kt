fun protectedInput(variableName: String): Int {
    do {
        try {
            print("Enter $variableName: ")
            return readln().toInt()
        } catch (e: Exception) {
            println("${variableName.uppercase()} must be an integer!")
        }
    } while (true)
}

fun main() {
    val n: Int = protectedInput("n")
    val m: Int = protectedInput("m")
    val a: Int = protectedInput("a")
    val b: Int = protectedInput("b")

    val s: Float = (b + m).toFloat() / 2 * (m - b + 1) * (n - a + 1)

    println("S = $s")
}