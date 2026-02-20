package acmicpc26076

import java.io.*
import java.util.*

/* 곰곰이의 식단 관리 2, 0-1 bfs
https://www.acmicpc.net/problem/26076
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
    val dx = arrayOf(0, 1, -1, 0)
    val dy = arrayOf(1, 0, 0, -1)

    val dp = Array(N) { IntArray(M) }
    val q = ArrayDeque<Coord>()
    q.add(Coord(0, 0, 0))
    dp[0][0] = 1
    while (q.isNotEmpty()) {
        val c = q.poll()
        for (i in 0..3) {
            val ny = c.y + dy[i]
            val nx = c.x + dx[i]
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue
            if (map[ny][nx] == 1) continue
            if (dp[ny][nx] != 0) continue
            dp[ny][nx] = 1
            q.add(Coord(ny, nx, 0))
        }
    }

    if (dp[N - 1][M - 1] == 0) {
        println(0)
        return
    }

    val ddx = arrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val ddy = arrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

    val visited = Array(N) { BooleanArray(M) }
    val deque = ArrayDeque<Coord>()

    for (x in 1 until M) {
        val cost = if (map[0][x] == 1) 0 else 1
        visited[0][x] = true
        if (cost == 0) {
            deque.addFirst(Coord(0, x, cost))
        } else {
            deque.addLast(Coord(0, x, cost))
        }
    }
    for (y in 1 until N - 1) {
        if (visited[y][M - 1]) continue
        val cost = if (map[y][M - 1] == 1) 0 else 1
        visited[y][M - 1] = true
        if (cost == 0) {
            deque.addFirst(Coord(y, M - 1, cost))
        } else {
            deque.addLast(Coord(y, M - 1, cost))
        }
    }

    while (deque.isNotEmpty()) {
        val c = deque.pollFirst()

        // [도] 도달 체크: 아랫변 또는 왼쪽변 (S, E 제외)
        if ((c.y == N - 1 || c.x == 0)
            && !(c.y == 0 && c.x == 0)
            && !(c.y == N - 1 && c.x == M - 1)
        ) {

            if (c.count <= 1) println(1) else println(2)
            return
        }

        for (i in 0..7) {
            val ny = c.y + ddy[i]
            val nx = c.x + ddx[i]

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue
            if (visited[ny][nx]) continue

            visited[ny][nx] = true
            val nextCost = c.count + if (map[ny][nx] == 1) 0 else 1

            if (map[ny][nx] == 1) {
                deque.addFirst(Coord(ny, nx, nextCost))
            } else {
                deque.addLast(Coord(ny, nx, nextCost))
            }
        }
    }

    println(2)
}

private data class Coord(val y: Int, val x: Int, val count: Int)

/*
5 5
0 0 0 0 0
0 0 0 1 0
0 0 0 0 0
0 1 0 0 0
0 0 0 0 0
 */