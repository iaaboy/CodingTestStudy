package acmicpc23250

import java.io.*
import java.util.*

/* 하노이 탑 K, 재귀
https://www.acmicpc.net/problem/23250
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val K = st.nextToken().toLong()

    val disk = java.lang.Long.numberOfTrailingZeros(K) + 1
    val t = (K - (1L shl (disk - 1))) shr disk

    val dir = if ((N % 2) == (disk % 2)) -1 else 1

    val from = ((t * dir % 3 + 3) % 3) + 1
    val to   = (((t + 1) * dir % 3 + 3) % 3) + 1

    println("$from $to")
}