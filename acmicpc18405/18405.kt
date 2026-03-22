package acmicpc18405

import java.io.*
import java.util.*

/* 경쟁적 전염, 너비 우선 탐색.
https://www.acmicpc.net/problem/18405
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val map = Array(N) {
        st = StringTokenizer(bf.readLine())
        IntArray(N) {
            st.nextToken().toInt()
        }
    }
    st = StringTokenizer(bf.readLine())
    val S = st.nextToken().toInt()
    val Y = st.nextToken().toInt()
    val X = st.nextToken().toInt()

    val dx = arrayOf(0, 1, -1, 0)
    val dy = arrayOf(1, 0, 0, -1)

    val q = ArrayDeque<Coord>()
    for (id in 1..K) {
        for (y in 0..<N) {
            for (x in 0..<N) {
                if (map[y][x] == id) {
                    q.add(Coord(y, x, 0, id))
                }
            }
        }
    }

    while (q.isNotEmpty()) {
        val c = q.poll()
        for (i in 0..<4) {
            val nx = c.x + dx[i]
            val ny = c.y + dy[i]
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue
            if (map[ny][nx] == 0 && c.tick + 1 <= S) {
                map[ny][nx] = c.vId
                q.add(Coord(ny, nx, c.tick + 1, c.vId))
            }
        }
    }
//    for (ints in map) {
//        println(ints.joinToString(" "))
//    }

    println(map[Y - 1][X - 1])

}

data class Coord(val y: Int, val x: Int, val tick: Int, val vId: Int)