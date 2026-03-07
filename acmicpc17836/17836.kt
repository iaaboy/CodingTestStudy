package acmicpc17836

import java.io.*
import java.util.*

/* 공주님을 구해라!, dfs
https://www.acmicpc.net/problem/17836
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val T = st.nextToken().toInt()
    lateinit var sword : Coord
    val map = Array(N) {
        IntArray(M)
    }

    for (i in 0 until N) {
        st = StringTokenizer(bf.readLine())
        for (j in 0 until M) {
            map[i][j] = st.nextToken().toInt()
            if (map[i][j] ==2) {
                sword = Coord(i, j, 0)
            }
        }
    }

    val history = Array(N) {
        IntArray(M) {
            Int.MAX_VALUE
        }
    }
    val q = ArrayDeque<Coord>()
    q.add(Coord(0, 0, 0))
    history[0][0] = 0

    val dx = arrayOf(0, 1, -1, 0)
    val dy = arrayOf(-1, 0, 0, 1)
    while (q.isNotEmpty()) {
        val c = q.poll()
        for (i in 0..3) {
            val nx = c.x + dx[i]
            if (nx < 0 || nx >= M) continue
            val ny = c.y + dy[i]
            if (ny < 0 || ny >= N) continue

            if ((map[ny][nx] == 0 || map[ny][nx] == 2)
                && history[ny][nx] > c.count + 1
            ) {
                history[ny][nx] = c.count + 1
                if (c.count >= T) continue
                q.add(Coord(ny, nx, c.count + 1))
            }
        }
    }

    var shortCut = Int.MAX_VALUE
    if (history[sword.y][sword.x] != Int.MAX_VALUE) {
        shortCut = history[sword.y][sword.x] + (N - 1 - sword.y) + (M - 1 - sword.x)
    }
    shortCut = minOf(shortCut, history[N - 1][M - 1])
    if (shortCut > T) {
        println("Fail")
    } else {
        println(minOf(shortCut, history[N - 1][M - 1]))
    }
//
//    for (ints in history) {
//        println(ints.joinToString(" "))
//    }
}

private data class Coord(
    val y: Int,
    val x: Int,
    val count: Int
)
