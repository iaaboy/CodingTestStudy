package acmicpc11056

import java.io.*
import kotlin.math.max

/* 두 부분 문자열, LIS
https://www.acmicpc.net/problem/11056
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val a = bf.readLine().toCharArray()
    val b = bf.readLine().toCharArray()
    val dp = Array(a.size + 1) { IntArray(b.size + 1) }

    for (i in 1..<dp.size) {
        for (j in 1..<dp[0].size) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    val totalSize = a.size + b.size - dp[a.size][b.size]
    println(totalSize)
}
