package acmicpc1512

import java.io.*

/* 주기문으로 바꾸기, 브룻포스
https://www.acmicpc.net/problem/1512
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val M = br.readLine().toInt()
    val S = br.readLine()
    val N = S.length

    var ans = Int.MAX_VALUE

    for (p in 1..M) {
        var cost = 0

        for (r in 0 until p) {
            val cnt = IntArray(4)
            var size = 0
            var i = r

            while (i < N) {
                when (S[i]) {
                    'A' -> cnt[0]++
                    'C' -> cnt[1]++
                    'G' -> cnt[2]++
                    'T' -> cnt[3]++
                }
                size++
                i += p
            }

            val max = cnt.max()
            cost += size - max
        }

        ans = minOf(ans, cost)
    }

    println(ans)
}
