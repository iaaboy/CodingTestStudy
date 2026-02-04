package acmicpc1484

import java.io.*

/* 다이어트, 투 포인터
https://www.acmicpc.net/problem/1484
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val G = bf.readLine().toLong()
    val sb = StringBuilder()
    var prev = 2.toDouble()
    var now = 1.toDouble()
    var hasResult = false
    while (true) {
        val gap = prev * prev - now * now
        if (gap < G) {
            prev++
        } else if (gap > G) {
            now++
        } else {
            sb.append(prev.toInt()).append('\n')
//            println("$prev $now $gap")
            prev++
            hasResult = true
        }
        if (prev > 100000) break
    }
    if (hasResult) {
        print(sb)
    } else {
        println(-1)
    }
}
