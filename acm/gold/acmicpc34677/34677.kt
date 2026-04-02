package acm.gold.acmicpc34677

import java.util.StringTokenizer
import kotlin.math.min

/* 최적의 분할, dp
https://www.acmicpc.net/problem/34677
 */

fun main() {
    val n = readln().toInt()
    val A = IntArray(n + 1)
    val B = IntArray(n + 1)

    var st = StringTokenizer(readln())
    for (i in 1..n) A[i] = st.nextToken().toInt()

    st = StringTokenizer(readln())
    for (i in 1..n) B[i] = st.nextToken().toInt()

    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 1..n) {
        var minA = Int.MAX_VALUE
        var minB = Int.MAX_VALUE
        var idxA = -1
        var idxB = -1

        for (j in i downTo 1) {

            // A[j] 포함
            if (A[j] < minA) {
                minA = A[j]
                idxA = j
            }

            // B[j] 포함
            if (B[j] < minB) {
                minB = B[j]
                idxB = j
            }

            if (idxA == idxB) {
                val candidate = dp[j - 1] + 1
                dp[i] = min(dp[i], candidate)
            }
        }
    }

    println(dp[n])
}