package acmicpc1727

import java.io.*
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.min

/* 커플 만들기, dp
https://www.acmicpc.net/problem/1727
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    var men = IntArray(N) { st.nextToken().toInt() }
    st = StringTokenizer(br.readLine())
    var women = IntArray(M) { st.nextToken().toInt() }

    men.sort()
    women.sort()

    if (N > M) {
        val tmpArr = men; men = women; women = tmpArr
        val tmp = N; N = M; M = tmp
    }

    val INF = 1_000_000_000_000L
    val dp = Array(N + 1) { LongArray(M + 1) { INF } }

    for (j in 0..M) dp[0][j] = 0

    for (i in 1..N) {
        for (j in 1..M) {
            dp[i][j] = min(
                dp[i][j - 1],
                dp[i - 1][j - 1] + abs(men[i - 1] - women[j - 1])
            )
        }
    }

    println(dp[N][M])
}