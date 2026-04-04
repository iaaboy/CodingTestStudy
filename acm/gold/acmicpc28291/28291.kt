package acm.gold.acmicpc28291

import java.util.ArrayDeque
import java.util.StringTokenizer

/* 레드스톤, 깊이 우선 탐색
https://www.acmicpc.net/problem/28291
 */

fun main() {
    val st = StringTokenizer(readln())
    val W = st.nextToken().toInt()
    val H = st.nextToken().toInt()
    val N = readln().toInt()
    val map = Array(H) { IntArray(W) }
    val electric = Array(H) { IntArray(W) }
    val keyMap = hashMapOf("redstone_block" to 1, "redstone_dust" to 2, "redstone_lamp" to 3)

    /*
레드스톤 가루(redstone_dust)는 상하좌우로 인접한 회로 블록에 매초마다 전기 신호를 전달하며,
전달할 회로 블록에 더 큰 전기 신호가 있다면 전달하지 않는다.

레드스톤 블록(redstone_block)은 전기 신호를 15만큼 가지고 있으며
상하좌우로 인접한 회로 블록에 15만큼의 전기 신호를 매초마다 전달한다.

레드스톤 램프(redstone_lamp)는 1 이상의 전기 신호를 받을 경우 불이 켜진다.

     */
    val q = ArrayDeque<Coord>()

    repeat(N) {
        val st = StringTokenizer(readln())
        val value = keyMap.get(st.nextToken()) ?: 0
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        map[y][x] = value
        if (map[y][x] == 1) {
            electric[y][x] = 16
            q.add(Coord(y, x, 16))
        }
    }

    val dx = arrayOf(0, 1, -1, 0)
    val dy = arrayOf(1, 0, 0, -1)

    while (q.isNotEmpty()) {
        val c = q.poll()

        for (i in 0..3) {
            val nx = c.x + dx[i]
            val ny = c.y + dy[i]
            if (nx < 0 || nx >= W || ny < 0 || ny >= H) continue
            if (map[ny][nx] == 2) { //1빼고 전달
                if (electric[ny][nx] < c.value - 1) {
                    electric[ny][nx] = c.value - 1
                    q.add(Coord(ny, nx, c.value - 1))
                }
            } else if (map[ny][nx] == 1) { //do nothing

            } else if (map[ny][nx] == 3) { //lamp
                electric[ny][nx] = c.value - 1
            }
        }
    }

//    for (ints in map) {
//        println(ints.joinToString(" "))
//    }
//    for (ints in electric) {
//        println(ints.joinToString(" "))
//    }

    for (y in 0..<H) {
        for (x in 0..<W) {
            if (map[y][x] == 3 && electric[y][x] == 0) {
                println("failed")
                return
            }
        }
    }

    println("success")

}

data class Coord(val y: Int, val x: Int, val value: Int)

/*
15 1
15
redstone_block 0 0
redstone_dust 1 0
redstone_dust 2 0
redstone_dust 3 0
redstone_dust 4 0
redstone_dust 5 0
redstone_dust 6 0
redstone_dust 7 0
redstone_dust 8 0
redstone_dust 9 0
redstone_dust 10 0
redstone_dust 11 0
redstone_dust 12 0
redstone_lamp 13 0
redstone_lamp 14 0
 */