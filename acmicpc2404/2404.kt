package acmicpc2404

import java.io.*
import java.util.*

/* 단위 분수로 분할, 백트래킹 피마리드 분수
https://www.acmicpc.net/problem/2404
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val P = st.nextToken().toLong()
    val Q = st.nextToken().toLong()
    val A = st.nextToken().toInt()
    val N = st.nextToken().toInt()

    fun gcd(a: Long, b: Long): Long {
        var x = a
        var y = b
        while (y != 0L) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }

    var answer = 0
    fun dfs(p: Long, q: Long, depth: Int, lastX: Long, mul: Long) {

        if (p == 0L) {
            println("$p, $q, $depth, $lastX, $mul")
            answer++
            return
        }

        if (depth >= N) return

        var start = (q + p - 1) / p   // ceil(q/p)
        start = maxOf(start, lastX)

        var x = start
        while (true) {

            if (mul * x > A) break

            val np = p * x - q
            val nq = q * x

            if (np < 0) {
                x++
                continue
            }

            val g = gcd(np, nq)
            dfs(
                np / g,
                nq / g,
                depth + 1,
                x,
                mul * x
            )

            x++
        }
    }

    dfs(P, Q, 0, 1L, 1L)
    println(answer)
}