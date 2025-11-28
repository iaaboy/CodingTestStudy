package baseForm

import java.io.*

fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val a = bf.readLine()
    val b = bf.readLine()

    val pay = when (a.contentEquals(b)) {
        true -> 0
        else -> 1550
    }
    println(pay)
}

