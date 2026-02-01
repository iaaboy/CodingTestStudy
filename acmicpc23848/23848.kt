package acmicpc23848

import java.io.*
import kotlin.math.sqrt

/* 등비수열의 합, 수학 브루트 포스
https://www.acmicpc.net/problem/23848
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toLong()

    val maxN = sqrt(N.toDouble()).toLong()

    for (r in 2.. maxN) {
        var sum = 1L + r + r * r
        var term = r * r
        var count = 3
        while (sum <= N) {
            if (N % sum == 0L) {
                val a = N / sum

                val sb = StringBuilder()
                sb.append(count).append("\n")
                var cur = a
                repeat(count) {
                    sb.append(cur).append(' ')
                    cur *= r
                }
                println(sb.toString())
                return
            }

            term *= r
            sum += term
            count++
        }
    }

    println("-1")
}
