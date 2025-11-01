package baseForm

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val inStr = bf.readLine()
    println(":fan::fan::fan:\n" +
            ":fan::$inStr::fan:\n" +
            ":fan::fan::fan:")
}