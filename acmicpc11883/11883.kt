package acmicpc11883

import java.io.*

/* 생일수 I, dp
https://www.acmicpc.net/problem/11883
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val maxN = 1000000
//    val maxN = 100
    val dp = Array(maxN + 1) {
        IntArray(3) {
            Int.MAX_VALUE / 2
        }
    }
    dp[0][0] = 0
    dp[0][1] = 0
    dp[0][2] = 0
    val birthNum = arrayOf(3,5,8)
    for (i in 0 .. maxN) {
        for (j in 0 until 3) {
            var minVal = Int.MAX_VALUE
            val prevIndex = i - birthNum[j]
            if (prevIndex < 0) continue
            for (k in 0 until 3) {
                minVal = minVal.coerceAtMost(dp[prevIndex][k] + 1)
            }
            dp[i][j] = dp[i][j].coerceAtMost(minVal)
        }
    }

//    for (j in 0 until 3) {
//        for (i in 0 .. maxN) {
//            if (dp[i][j] == Int.MAX_VALUE /2) {
//                print("- ")
//            } else
//                print("${dp[i][j]} ")
//        }
//        println()
//    }

    val T = bf.readLine().toInt()
    val answer = StringBuilder()
    val nonBirth = hashSetOf(1,2,4,7)
    repeat(T) {
        var N = bf.readLine().toInt()
        val sb = StringBuilder()
        if (nonBirth.contains(N)) {
            answer.append("-1\n")
        } else {
            while (N > 0) {
                var value = Int.MAX_VALUE
                var index = 0
                for ((i, v) in dp[N].withIndex()) {
                    if (value >= v) {
                        value = v
                        index = i
                    }
                }
                sb.append(birthNum[index])
                N -= birthNum[index]
            }
            sb.reverse()
            sb.append("\n")
            answer.append(sb)
        }
    }
    print(answer)
}