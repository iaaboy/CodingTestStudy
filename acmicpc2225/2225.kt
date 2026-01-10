package acmicpc2225

import java.io.*
import java.util.*

/* 합분해, DP
https://www.acmicpc.net/problem/2225
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val MOD = 1000000000
    val dp = Array(K + 1) { LongArray(N + 1) }

    // 초기값: dp[k][0] = 1
    for (k in 1..K) dp[k][0] = 1

    // dp[1][n] = 1
    for (n in 0..N) dp[1][n] = 1

    for (k in 2..K) {
        for (n in 1..N) {
            dp[k][n] = (dp[k][n - 1] + dp[k - 1][n]) % MOD
        }
    }

    println(dp[K][N])
}