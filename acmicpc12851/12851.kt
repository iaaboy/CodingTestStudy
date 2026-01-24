package acmicpc12851

import java.io.*
import java.util.*

/* 숨바꼭질 2, 너비우선 탐색
https://www.acmicpc.net/problem/12851
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val MAX = 100000 * 2

    val dist = IntArray(MAX) {-1}
    val count = IntArray(MAX)

    val q = ArrayDeque<Int>()
    q.add(N)
    dist[N] = 0
    count[N] = 1

    while (q.isNotEmpty()) {
        val c = q.poll()
//        println(c)

        for (next in intArrayOf(c - 1, c + 1, c * 2)) {
            if (next < 0 || next >= MAX) continue
            if (dist[next] == -1) {
                dist[next] = dist[c] + 1
                count[next] = count[c]
                q.add(next)
            } else if (dist[next] == dist[c] + 1) {
                count[next] += count[c]
            }
        }
    }

    println(dist[K])
    println(count[K])

}
