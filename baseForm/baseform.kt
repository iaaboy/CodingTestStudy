package baseForm

import java.io.*
import java.math.BigInteger

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val number = BigInteger(bf.readLine())
    var diff = BigInteger("1")
    val two = BigInteger("2")
    var count = 64
    val maxVal = BigInteger("18446744073709551616")
    while (count > 0) {
        if (maxVal.subtract(diff) == number) {
//            println(diff)
            println(count)
            break
        }
        diff = diff.multiply(two)
        count--
    }
}

