import java.util.*

fun main() {
    println(generateSecretToken())
}

fun generateSecretToken(): String {
    val r = Random()
    return java.lang.Long.toHexString(r.nextLong())
}