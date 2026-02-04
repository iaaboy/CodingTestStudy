package acmicpc2600

import java.io.*
import java.util.*

/* 구슬게임, 게임이론, dp
https://www.acmicpc.net/problem/2600
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val marbles = IntArray(3) {
        st.nextToken().toInt()
    }
    val maxK = 500
    val dp = Array(maxK + 1) {
        BooleanArray(maxK + 1)
    }
    for (i in marbles) {
        dp[0][i] = true
        dp[i][0] = true
    }
    for (y in 0 .. maxK) {
        for (x in 0 .. maxK) {
            var isWin = false
            for (i in marbles) {
                if (x - i >= 0 && !dp[y][x - i]) {
                    isWin = true
                    break
                }
                if (y- i >= 0 && !dp[y - i][x]) {
                    isWin = true
                    break
                }
            }
            if (isWin) dp[y][x] = true
        }
    }
//    for (i in 0 .. 10) {
//        for (j in 0 .. 10) {
//            val result = when {
//                dp[i][j] -> "W"
//                else -> "L"
//            }
//            print("${result} ")
//        }
//        println()
//    }
    val sb = StringBuilder()
    repeat(5) {
        val st = StringTokenizer(bf.readLine())
        val y = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        when (dp[y][x]) {
            true -> sb.append("A\n")
            false -> sb.append("B\n")
        }
    }
    print(sb)
}
