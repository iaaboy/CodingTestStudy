package acmicpc9471

import java.io.*
import java.util.*

/* 피사노 주기, 피보나치 . 피사노 주기
https://www.acmicpc.net/problem/9471
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val st = StringTokenizer(bf.readLine())
        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()
        val pis = pisano(M)
        sb.append("$N $pis\n")
    }
    print(sb)
}

fun pisano(m: Int): Int {
    var prev = 0
    var cur = 1
    val mm = 1L * m * m   // Long으로 계산

    for (i in 1..mm) {
        val next = (prev + cur) % m
        prev = cur
        cur = next
        if (prev == 0 && cur == 1) return i.toInt()
    }
    return -1
}
