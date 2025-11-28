package acmicpc32714

import java.io.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toLong()
    val ans = when (N) {
        2L -> {
            1
        }
        3L -> {
            3
        }
        else -> {
            3 * N - 4
        }
    }
    println(ans)
}