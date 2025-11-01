package acmicpc14916

import java.io.BufferedReader
import java.io.InputStreamReader

/* 거스름돈
https://www.acmicpc.net/problem/14916
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    var minCount = Int.MAX_VALUE
    for (i in 0 .. N / 5 + 1) {
        val remained = N - 5 * i
        if (remained % 2 == 0 && remained >= 0) {
            minCount = minCount.coerceAtMost(i + remained / 2)
        }
    }
    if (minCount == Int.MAX_VALUE) minCount = -1
    println(minCount)
}