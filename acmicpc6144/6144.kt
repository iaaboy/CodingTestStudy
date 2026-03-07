package acmicpc6144

import java.io.*
import java.util.StringTokenizer

/* Charm Bracelet, 배낭answp
https://www.acmicpc.net/problem/6144
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val dp = IntArray(M + 1)

    repeat(N) {
        val line = StringTokenizer(br.readLine())
        val weight = line.nextToken().toInt()
        val value = line.nextToken().toInt()

        for (w in M downTo weight) {
            dp[w] = maxOf(dp[w], dp[w - weight] + value)
        }
    }

    println(dp[M])
}
