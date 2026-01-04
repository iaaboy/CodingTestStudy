package acmicpc15483

import java.io.*

/* 최소 편집, LIS와 유사한 DP
https://www.acmicpc.net/problem/15483
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val start = bf.readLine().toCharArray()
    val sSize = start.size
    val end = bf.readLine().toCharArray()
    val eSize = end.size
    val dp = Array(sSize + 1) {
        IntArray(eSize + 1)
    }

    for (i in 0..sSize) dp[i][0] = i          // A i개 삭제
    for (j in 0..eSize) dp[0][j] = j          // B j개 삽입

    for (s in 1 .. sSize) {
        val aChar = start[s - 1]
        for (e in 1 .. eSize) {
            val bChar = end[e - 1]

            val deleteCost = dp[s - 1][e] + 1
            val insertCost = dp[s][e - 1] + 1
            val replaceCost = dp[s - 1][e - 1] + if (aChar == bChar) 0 else 1

            dp[s][e] = minOf(deleteCost, insertCost, replaceCost)
        }
    }
    println(dp[sSize][eSize])
}