package acm.gold.acmicpc3055

import java.util.ArrayDeque
import java.util.StringTokenizer

/* 탈출, bfs
https://www.acmicpc.net/problem/3055
 */

fun main() {
    val st = StringTokenizer(readln())
    val R = st.nextToken().toInt()
    val C = st.nextToken().toInt()
    val sQ = ArrayDeque<Coord>()
    val waterQ = ArrayDeque<Coord>()
    val map = Array(R) { y ->
        val column = readln().toCharArray()
        for (x in 0..<C) {
            if (column[x] == 'S') {
                sQ.add(Coord(y, x, 1))
            } else if (column[x] == '*') {
                waterQ.add(Coord(y, x, 1))
            }
        }
        column
    }

//    fun printMap() {
//        for (chars in map) {
//            println(chars.joinToString(" "))
//        }
//    }

    val dx = arrayOf(0, 1, -1, 0)
    val dy = arrayOf(1, 0, 0, -1)
    while (sQ.isNotEmpty()) {
        val currentS = sQ.poll()

        //handle waterQ
        while (waterQ.isNotEmpty() && waterQ.peek().count <= currentS.count) {
            val currentWater = waterQ.poll()
            for (i in 0..<4) {
                val ny = currentWater.y + dy[i]
                val nx = currentWater.x + dx[i]
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue
                if (map[ny][nx] == '.') {
                    map[ny][nx] = '*'
                    waterQ.add(Coord(ny, nx, currentWater.count + 1))
                }
            }
        }

        for (i in 0..<4) {
            val ny = currentS.y + dy[i]
            val nx = currentS.x + dx[i]
            if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue
            if (map[ny][nx] == '.') {
                map[ny][nx] = 'K'//('0' + currentS.count)
                sQ.add(Coord(ny, nx, currentS.count + 1))
            } else if (map[ny][nx] == 'D') {
                println(currentS.count)
//                printMap()
                return
            }
        }
    }

//    printMap()
    println("KAKTUS")
}

data class Coord(val y: Int, val x: Int, val count: Int = 0)
