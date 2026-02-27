package acmicpc11559

import java.io.*
import java.util.ArrayDeque

/* Puyo Puyo, 너비우선 탐색
https://www.acmicpc.net/problem/11559
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val map = Array(12) {
        CharArray(1)
    }

    for (i in 0 until 12) {
        map[12 - i - 1] = bf.readLine().toCharArray()
    }


    lateinit var visit: Array<BooleanArray>
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    fun setMark(y: Int, x: Int): Boolean {
        val q = ArrayDeque<Coord>()
        val history = ArrayDeque<Coord>()
        visit[y][x] = true
        q.add(Coord(y, x))
        while (q.isNotEmpty()) {
            val c = q.poll()
            history.add(c)
            for (i in 0..3) {
                val nx = c.x + dx[i]
                val ny = c.y + dy[i]
                if (nx < 0 || nx >= 6 || ny < 0 || ny >= 12) continue
                if (!visit[ny][nx] && map[ny][nx] == map[c.y][c.x]) {
                    visit[ny][nx] = true
                    q.add(Coord(ny, nx))
                }
            }
        }
        if (history.size >= 4) {
            while (history.isNotEmpty()) {
                val c = history.poll()
                map[c.y][c.x] = '0'
            }
            return true
        }
        return false
    }

    var hasBoom = true
    var bombCount = 0
    while (hasBoom) {
        visit = Array(12) {
            BooleanArray(6)
        }
        hasBoom = false
        for (x in 0 until 6) {
            for (y in 0 until 12) {
                if (map[y][x] != '.') {
                    if (!visit[y][x]) {
                        hasBoom = hasBoom or setMark(y, x)
                    }
                } else {
                    break
                }
            }
        }

        if (hasBoom) {
            bombCount++
            for (x in 0 until 6) {
                var gap = 0
                for (y in 0 until 12) {
                    if (map[y][x] == '0') {
                        gap++
                        map[y][x] = '.'
                    } else {
                        if (gap > 0) {
                            map[y - gap][x] = map[y][x]
                            map[y][x] = '.'
                        }
                    }
                }
            }
        }

//        println("mapPrint")
//        for (chars in map) {
//            println(chars.joinToString(" "))
//        }
    }
    println(bombCount)
}

private data class Coord(val y: Int, val x: Int)
