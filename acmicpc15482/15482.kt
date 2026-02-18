package acmicpc15482

import java.io.*
import kotlin.math.max

/* 한글 LCS, LCS dp
https://www.acmicpc.net/problem/15482
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val a = bf.readLine().toCharArray()
    val b = bf.readLine().toCharArray()
    val dp = Array<IntArray>(a.size + 1) { IntArray(b.size + 1) }

    for (i in 1..<dp.size) {
        for (j in 1..<dp[0].size) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    println(dp[a.size][b.size])
}
