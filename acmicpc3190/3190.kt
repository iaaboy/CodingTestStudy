package acmicpc3190

import java.io.*
import java.util.*

/* 뱀, 시뮬레이션 구현 큐
https://www.acmicpc.net/problem/3190
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val K = bf.readLine().toInt()
    val map = Array(N) {
        IntArray(N)
    }

    repeat(K) {
        val st = StringTokenizer(bf.readLine())
        val y = st.nextToken().toInt() - 1
        val x = st.nextToken().toInt() - 1
        map[y][x] = 1
    }

    val L = bf.readLine().toInt()
    val snake = ArrayDeque<Coord>()
    snake.add(Coord(0, 0))
    map[0][0] = 2

    val dx = arrayOf(1, 0, -1, 0) //동, 남, 서, 북
    val dy = arrayOf(0, 1, 0, -1)

    var curDir = 0
    var headX = 0
    var headY = 0
    var isGameOn = true
    var moveCount = 0

    var count = 0
    var dir: Char
    repeat(L) {
        val st = StringTokenizer(bf.readLine())
        count = st.nextToken().toInt()
        dir = st.nextToken()[0]
        while (isGameOn && count != moveCount) {
            headY += dy[curDir]
            headX += dx[curDir]
            moveCount++


            //범위에서 벗어남
            if (headY !in 0..<N || headX !in 0..<N) {
                isGameOn = false
                continue
            }
            //몸통에 부딪힘
            if (map[headY][headX] == 2) {
                isGameOn = false
                continue
            }
            if (map[headY][headX] == 1) { //사과
                snake.add(Coord(headY, headX))
                map[headY][headX] = 2
            } else { //그냥 땅
                snake.add(Coord(headY, headX))
                val sTail = snake.poll()
                map[sTail.y][sTail.x] = 0
                map[headY][headX] = 2
            }

//            println("$headY $headX $moveCount")
//            for (ints in map.reversed()) {
//                println(ints.joinToString(" "))
//            }
        }
        curDir = if (dir == 'D') {
            (curDir + 1) % 4
        } else {
            (curDir + 3) % 4
        }
    }

    while (isGameOn && count != 10000) {
        headY += dy[curDir]
        headX += dx[curDir]
        moveCount++


        //범위에서 벗어남
        if (headY !in 0..<N || headX !in 0..<N) {
            isGameOn = false
            continue
        }
        //몸통에 부딪힘
        if (map[headY][headX] == 2) {
            isGameOn = false
            continue
        }
        if (map[headY][headX] == 1) { //사과
            snake.add(Coord(headY, headX))
            map[headY][headX] = 2
        } else { //그냥 땅
            snake.add(Coord(headY, headX))
            val sTail = snake.poll()
            map[sTail.y][sTail.x] = 0
            map[headY][headX] = 2
        }

//        println("$headY $headX $moveCount")
//        for (ints in map.reversed()) {
//            println(ints.joinToString(" "))
//        }
    }

    println(moveCount)
}

private data class Coord(val y: Int, val x: Int)
