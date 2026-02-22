package acmicpc30678

import java.io.*

/* 별 안에 별 안에 별 찍기, 구현
https://www.acmicpc.net/problem/30678
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    var size = 1
    repeat(N) { size *= 5 }   // 5^N
    val canvas = Array(size) { CharArray(size) { ' ' } }
    val star = arrayOf(
        booleanArrayOf(false, false, true, false, false),
        booleanArrayOf(false, false, true, false, false),
        booleanArrayOf(true, true, true, true, true),
        booleanArrayOf(false, true, true, true, false),
        booleanArrayOf(false, true, false, true, false)
    )

    fun draw(cy: Int, cx: Int, depth: Int) {
        if (depth == 0) {
            canvas[cy][cx] = '*'
            return
        }

        val block = size / Math.pow(5.0, (N - depth + 1).toDouble()).toInt()
        for (y in 0 until 5) {
            for (x in 0 until 5) {
                if (star[y][x]) {
                    draw(cy + y * block, cx + x * block, depth - 1)
                }
            }
        }
    }
    draw(0, 0, N)
    val sb = StringBuilder()
    for (row in canvas) {
        for (c in row) sb.append(c)
        sb.append('\n')
    }
    print(sb)
}
