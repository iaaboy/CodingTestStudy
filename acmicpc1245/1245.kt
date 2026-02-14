package acmicpc1245

import java.io.*
import java.util.*

/* 농장 관리, 너비 우선 탐색
https://www.acmicpc.net/problem/1245
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val map = Array(N) {
        val st = StringTokenizer(bf.readLine())
        IntArray(M) {
            st.nextToken().toInt()
        }
    }

    var count = 0
    val dy = arrayOf(0, 1, -1, 0, 1, 1, -1, -1)
    val dx = arrayOf(1, 0, 0, -1, 1, -1, 1, -1)
    while (true) {
        var coord: Coord? = null
        var max = 0
        for (y in 0..< N) {
            for (x in 0..< M) {
                if (map[y][x] > max) {
                    max = map[y][x]
                    coord = Coord(y, x, map[y][x])
                }
            }
        }
        if (coord == null) {
            break
        }
        val q = ArrayDeque<Coord>()
        q.add(coord)
        map[coord.y][coord.x] = 0
        count++
        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (i in 0..7) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue
                if (map[ny][nx] == 0) continue
                if (map[ny][nx] <= cur.height) {
                    q.add(Coord(ny, nx, map[ny][nx]))
                    map[ny][nx] = 0
                }
            }
        }
    }
    println(count)
}

private data class Coord(val y: Int, val x: Int, val height: Int)

/*

2 1 3 0 6 8 8
4 2 8 9 8 7 5

4 3 2 2 1 0 1
3 3 3 2 1 0 1
2 2 2 2 1 0 0
2 1 1 1 1 0 0
1 1 6 6 0 1 0
0 0 0 1 1 1 0
0 1 2 2 5 1 0
0 1 1 1 2 1 0
 */