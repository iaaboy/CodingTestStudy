package acmicpc15483

import java.io.*

/* 최소 편집, LIS와 유사한 DP
https://www.acmicpc.net/problem/15483
 */


private const val FROM_UP: Byte = 1     // delete A[i-1]
private const val FROM_LEFT: Byte = 2   // insert B[j-1]
private const val FROM_DIAG: Byte = 3   // match/replace

data class Op(val type: String, val detail: String)

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val start = bf.readLine().toCharArray()
    val sSize = start.size
    val end = bf.readLine().toCharArray()
    val eSize = end.size
    val dp = Array(sSize + 1) {
        IntArray(eSize + 1)
    }

    val parent = Array(sSize + 1) {
        ByteArray(eSize + 1)
    }
    dp[0][0] = 0
    for (i in 1..sSize) {
        dp[i][0] = i // A i개 삭제
        parent[i][0] = FROM_UP
    }
    for (j in 1..eSize) {
        dp[0][j] = j // B j개 삽입
        parent[0][j] = FROM_LEFT
    }

    for (s in 1 .. sSize) {
        val aChar = start[s - 1]
        for (e in 1 .. eSize) {
            val bChar = end[e - 1]

            val deleteCost = dp[s - 1][e] + 1
            val insertCost = dp[s][e - 1] + 1
            val replaceCost = dp[s - 1][e - 1] + if (aChar == bChar) 0 else 1

            var best = deleteCost
            var dir: Byte = FROM_UP

            if (insertCost < best) {
                best = insertCost
                dir = FROM_LEFT
            }
            if (replaceCost < best) {
                best = replaceCost
                dir = FROM_DIAG
            }

            dp[s][e] = best
            parent[s][e] = dir
        }
    }
    println(dp[sSize][eSize])

    //added for print log.

    val ops = ArrayList<Op>()
    val alignS = StringBuilder()
    val alignE = StringBuilder()

    var i = sSize
    var j = eSize
    while(i > 0 || j > 0) {
        when(parent[i][j]) {
            FROM_UP -> {
                val ch = start[i-1]
                ops.add(Op("DEL", "delete '$ch' from A"))
                alignS.append(ch)
                alignE.append('-')
                i--
            }
            FROM_LEFT -> {
                val ch = end[j-1]
                ops.add(Op("INS", "inser '$ch' to A (from B)"))
                alignS.append('-')
                alignE.append(ch)
                j--
            }
            FROM_DIAG -> {
                val aCh = start[i - 1]
                val bCh = end[j - 1]
                if (aCh == bCh) {
                    ops.add(Op("KEEP", "keep '$aCh'"))
                } else {
                    ops.add(Op("REP", "replace '$aCh' -> '$bCh'"))
                }
                alignS.append(aCh)
                alignE.append(bCh)
                i--
                j--
            }
        }
    }
    ops.reverse()
    alignS.reverse()
    alignE.reverse()

    // === 출력 (이해용) ===
    // 제출용이면 println(dist)만 남기면 됨
    val sb = StringBuilder()
    sb.append(alignS).append('\n')
    sb.append(alignE).append('\n')
    sb.append("Ops (").append(ops.size).append("):\n")
    for ((idx, op) in ops.withIndex()) {
        sb.append(idx + 1).append(". ").append(op.type).append(" - ").append(op.detail).append('\n')
    }
    print(sb.toString())

}