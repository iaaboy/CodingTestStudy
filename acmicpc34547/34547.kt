package acmicpc34547

import java.io.*
import java.util.*
import kotlin.math.max

/* 실력과 열정, dp
https://www.acmicpc.net/problem/34547
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val A = st.nextToken().toInt()
    val B = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val S: Int = A + B
    val dp = Array(N + 1) {
        LongArray(S + 1) { -1L }
    }

    dp[0][A] = 0L

    for (day in 1..N) {
        for (a in 0..S) {
            var best = -1L

            for (aPrev in 0..S) {
                val prev = dp[day - 1][aPrev]
                if (prev == -1L) continue

                if (aPrev <= a - K || aPrev >= a + K) {
                    best = max(best, prev)
                }
            }

            if (best != -1L) {
                val score = a.toLong() * (S - a).toLong()
                dp[day][a] = best + score
            }
        }
    }

    var answer = 0L
    for (a in 0..S) {
        answer = max(answer, dp[N][a])
    }

    print(answer)
}
