package acmicpc1987

import java.io.*
import java.util.*

/* 알파벳 풀이, dfs
https://www.acmicpc.net/problem/1987
 */

private lateinit var board: Array<CharArray>
private var R = 0
private var C = 0
private var ans = 0

private val dr = intArrayOf(0, 1, 0, -1)
private val dc = intArrayOf(1, 0, -1, 0)

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    R = st.nextToken().toInt()
    C = st.nextToken().toInt()
    board = Array(R) {
        bf.readLine().toCharArray()
    }

    dfs(0,0, 1 shl (board[0][0] - 'A'), 1)

    println(ans)
}

private fun dfs (r: Int, c: Int, used: Int, depth: Int) {
    if (depth > ans) ans = depth

    for (i in 0 until 4) {
        val nr = r + dr[i]
        val nc = c + dc[i]
        if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue

        val bit = 1 shl (board[nr][nc] - 'A')
        if ((used and bit) != 0) continue

        dfs(nr, nc, used or bit, depth + 1)
    }
}
