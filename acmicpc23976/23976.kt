package acmicpc23976

import java.io.*
import java.util.StringTokenizer

/* 문자열 나누기, dp
https://www.acmicpc.net/problem/23976
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val S = bf.readLine()
    val MOD = 1_000_000_007L

    val dp = Array(N + 1) { Array(K + 1) { LongArray(2) } }

    if (S[0] == '0') {
        dp[1][1][1] = 1
    } else {
        dp[1][1][0] = 1
    }

    for (i in 2..N) {
        val d = S[i - 1]
        for (k in 1..K) {
            val sum = (dp[i - 1][k - 1][0] + dp[i - 1][k - 1][1]) % MOD
            if (d == '0') {
                dp[i][k][1] = (dp[i][k][1] + sum) % MOD
            } else {
                dp[i][k][0] = (dp[i][k][0] + sum) % MOD
            }
            dp[i][k][0] = (dp[i][k][0] + dp[i - 1][k][0]) % MOD
        }
    }

    val ans = (dp[N][K][0] + dp[N][K][1]) % MOD
    println(ans)
}
