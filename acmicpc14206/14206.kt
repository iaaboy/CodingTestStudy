package acmicpc14206

import java.io.*
import java.util.*

/* 선데이 코딩, dp 누적합
https://www.acmicpc.net/problem/14206
 */

fun main() {

    val MOD = 1_000_000_007L

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val R = st.nextToken().toInt()
    val S = st.nextToken().toInt()

    val maxRank = (R - 1) * S + 1
    val dp = Array(R + 1) { LongArray(maxRank + 1) }
    dp[1][1] = 1L

    for (len in 2..R) {

        val maxValue = (len - 1) * S + 1
        var sum = 0L

        for (last in 1 until maxValue) {
            sum = (sum + dp[len - 1][last]) % MOD
            dp[len][last + 1] = sum
        }
    }

    var increasingCount = 0L
    for (v in 1..maxRank) {
        increasingCount = (increasingCount + dp[R][v]) % MOD
    }

    var fact = 1L
    for (i in 1..R) {
        fact = fact * i % MOD
    }

    val answer = increasingCount * fact % MOD
    println(answer)

}
