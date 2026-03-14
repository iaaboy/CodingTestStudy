package acmicpc14948

import java.io.*
import java.util.*

/* 군대탈출하기, 너비 우선 탐색
https://www.acmicpc.net/problem/14948
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val map = Array(n) {
        val st = StringTokenizer(bf.readLine())
        IntArray(m) {
            st.nextToken().toInt()
        }
    }
    val JUMPED = 1
    val NONE = 0
    val dp = Array(2) {
        Array(n) {
            IntArray(m) {
                Int.MAX_VALUE
            }
        }
    }

    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    val q = ArrayDeque<Coord>()
    q.add(Coord(0,0))
    dp[JUMPED][0][0] = map[0][0]
    dp[NONE][0][0] = map[0][0]
    while (q.isNotEmpty()) {
        val c = q.poll()
        for (i in 0 .. 3) {
            val ny = c.y + dy[i]
            val nx = c.x + dx[i]
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue
            if (dp[NONE][ny][nx] > maxOf(dp[NONE][c.y][c.x] , map[ny][nx])) {
                dp[NONE][ny][nx] = maxOf(dp[NONE][c.y][c.x], map[ny][nx])
                q.add(Coord(ny, nx))
            }
            if (dp[JUMPED][ny][nx] > maxOf(dp[JUMPED][c.y][c.x] , map[ny][nx])) {
                dp[JUMPED][ny][nx] = maxOf(dp[JUMPED][c.y][c.x] , map[ny][nx])
                q.add(Coord(ny, nx))
            }
            val nJumpY = c.y + dy[i] * 2
            val nJumpX = c.x + dx[i] * 2
            if (nJumpX < 0 || nJumpY < 0 || nJumpX >= m || nJumpY >= n) continue
            if (dp[JUMPED][nJumpY][nJumpX] > maxOf(dp[NONE][c.y][c.x] , map[nJumpY][nJumpX])) {
                dp[JUMPED][nJumpY][nJumpX] = maxOf(dp[NONE][c.y][c.x] , map[nJumpY][nJumpX])
                q.add(Coord(nJumpY, nJumpX))
            }
        }
    }

    println(minOf(dp[NONE][n-1][m-1], dp[JUMPED][n-1][m-1]))

}
data class Coord(val y : Int, val x : Int)

