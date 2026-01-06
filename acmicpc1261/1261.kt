package acmicpc1261

import java.io.*
import java.util.*

/* 알고스팟, 너비 우선 탐색
https://www.acmicpc.net/problem/1261
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val M = st.nextToken().toInt() // X
    val N = st.nextToken().toInt() // Y

    val map = Array(N) {
        val chArr = bf.readLine().toCharArray()
        IntArray(M) {
            chArr[it] - '0'
        }
    }
    val q = PriorityQueue<Coord> { a, b ->
        a.count - b.count
    }
    val dx = intArrayOf(1, 0, 0, -1)
    val dy = intArrayOf(0, 1, -1, 0)
    val initValue = when {
        map[0][0] == 0 -> 0
        else -> 1
    }
    val dp = Array(N) {
        IntArray(M) {
            Int.MAX_VALUE
        }
    }
    dp[0][0] = initValue
    q.add(Coord(0, 0, initValue))
    while (q.isNotEmpty()) {
        val c = q.poll()
        for (i in 0 until 4) {
            val nx = c.x + dx[i]
            val ny = c.y + dy[i]
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue

            if (map[ny][nx] == 0 && dp[ny][nx] > c.count) {
                //go next
                dp[ny][nx] = c.count
                q.add(Coord(ny, nx, c.count))
            }
            if (map[ny][nx] == 1 && dp[ny][nx] > c.count + 1) {
                //go next
                dp[ny][nx] = c.count + 1
                q.add(Coord(ny, nx, c.count + 1))
            }
        }
    }
//    for (ints in dp) {
//        println(ints.contentToString())
//    }
    println(dp[N - 1][M - 1])
}

private data class Coord(val y: Int, val x: Int, val count: Int)