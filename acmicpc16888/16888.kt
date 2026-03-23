package acmicpc16888

import java.io.*
import kotlin.math.sqrt

/* 루트 게임, 게임이론.
https://www.acmicpc.net/problem/16888
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val maxN = 1000001
//    val maxN = 101
    val squareList = ArrayList<Int> ()
    var i = 1
    while (i * i < maxN) {
        squareList.add(i * i)
        i++
    }
    val winArr = BooleanArray(maxN)
    for (sq in squareList) {
        winArr[sq] = true
    }

    for (i in 1 until maxN) {
        if (!winArr[i]) {
            var startNum = sqrt(i.toDouble()).toInt()
            var hasAny = true
            while (startNum >= 1) {
                hasAny = hasAny and winArr[i - startNum * startNum]
                startNum--
            }
            if (!hasAny) {
                winArr[i] = true
            }
        }
    }

    val sb = StringBuilder()
    repeat(T) {
        val N = bf.readLine().toInt()
        if (winArr[N]) {
            sb.append("koosaga\n")
        } else {
            sb.append("cubelover\n")
        }
    }
    print(sb)
}
