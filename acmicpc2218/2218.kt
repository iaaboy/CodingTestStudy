package acmicpc2218

import java.io.*
import java.util.*

/* 상자 안의 구슬, dp LCS 경로찾기
https://www.acmicpc.net/problem/2218
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val aSize = st.nextToken().toInt()
    val bSize = st.nextToken().toInt()

    val score = Array(N) {
        st = StringTokenizer(br.readLine())
        IntArray(N) { st.nextToken().toInt() }
    }

    st = StringTokenizer(br.readLine())
    val arrayA = IntArray(aSize) { st.nextToken().toInt() - 1 }

    st = StringTokenizer(br.readLine())
    val arrayB = IntArray(bSize) { st.nextToken().toInt() - 1 }

    val dp = Array(aSize + 1) { LongArray(bSize + 1) }
    val parent = Array(aSize + 1) { ByteArray(bSize + 1) }

    // base case
    for (bCnt in 1..bSize) parent[0][bCnt] = 2   // B만 버림
    for (aCnt in 1..aSize) parent[aCnt][0] = 1   // A만 버림

    for (aCnt in 1..aSize) {
        for (bCnt in 1..bSize) {

            val fromDropA = dp[aCnt - 1][bCnt]   // 1
            val fromDropB = dp[aCnt][bCnt - 1]   // 2

            val aIndex = arrayA[aCnt - 1]
            val bIndex = arrayB[bCnt - 1]
            val fromMatch = dp[aCnt - 1][bCnt - 1] +
                    score[aIndex][bIndex].toLong() // 3

            var bestScore = fromDropA
            var decision: Byte = 1

            if (fromDropB > bestScore) {
                bestScore = fromDropB
                decision = 2
            }
            if (fromMatch > bestScore) {
                bestScore = fromMatch
                decision = 3
            }

            dp[aCnt][bCnt] = bestScore
            parent[aCnt][bCnt] = decision
        }
    }

    val maxScore = dp[aSize][bSize]

    for (longs in dp) {
        println(longs.contentToString())
    }

    for (ps in parent) {
        println(ps.contentToString())
    }

    // 경로 복원
    val ops = IntArray(aSize + bSize)
    var len = 0
    var aCnt = aSize
    var bCnt = bSize

    while (aCnt > 0 || bCnt > 0) {
        when (parent[aCnt][bCnt].toInt()) {
            1 -> { ops[len++] = 1; aCnt-- }
            2 -> { ops[len++] = 2; bCnt-- }
            else -> { ops[len++] = 3; aCnt--; bCnt-- }
        }
    }

    val sb = StringBuilder()
    sb.append(maxScore).append('\n')
    for (k in len - 1 downTo 0) sb.append(ops[k]).append(' ')
    sb.append('\n')
    print(sb.toString())
}