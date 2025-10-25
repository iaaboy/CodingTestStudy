package acmicpc26651

import java.io.*
import kotlin.math.sqrt

/* 팬램그
https://www.acmicpc.net/problem/26651
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var N = bf.readLine().toInt()

    if (N == 0) {
        println("GBSISTHEBEST")
        return
    }
    val sb = StringBuilder()
    while (N > 1) {
        val headAndTail = getHeadAndTail(N)
        N = N - headAndTail*headAndTail
//        println("$headAndTail $N")
        generateString(sb, headAndTail - 1)
    }
    if (N == 1) {
        generateString(sb, 0)
    }
//    println(N)
    println(sb)
}

fun generateString(sb : StringBuilder, headAndTail: Int) {
    repeat(headAndTail) {
        sb.append('A')
    }
    sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    repeat(headAndTail) {
        sb.append('Z')
    }
}

fun getHeadAndTail(n: Int) : Int {
    return sqrt(n.toDouble()).toInt()
}
