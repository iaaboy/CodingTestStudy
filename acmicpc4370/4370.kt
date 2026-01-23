package acmicpc4370

import java.io.*

/* 곱셈 게임, 게임이론
https://www.acmicpc.net/problem/4370
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    while (true) {
        val line = bf.readLine() ?: break
        val n = line.toInt()
        var isBackWin = true
        var p = 1L
        while (p < n) {
            if (isBackWin) {
                p *= 9L
            } else {
                p *= 2L
            }
            isBackWin = !isBackWin;
        }
        if (!isBackWin) {
            sb.append("Baekjoon wins.\n");
        } else {
            sb.append("Donghyuk wins.\n");
        }
    }
    print(sb)
}
