package acmicpc2458

import java.io.*
import java.util.StringTokenizer

/* 키 순서
https://www.acmicpc.net/problem/2458
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    st.nextToken()
    val route = Array(N) {
        BooleanArray(N)
    }
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        val small = st.nextToken().toInt() - 1
        val big = st.nextToken().toInt() - 1
        route[small][big] = true
    }

    for (m in 0 until N) {
        for (s in 0 until N) {
            if (m == s) continue
            for (e in 0 until N) {
                if (e == s) continue
                if (route[s][e]) continue
                if (route[s][m] && route[m][e]) route[s][e] = true
            }
        }
    }

//    for (i in 0 until N) {
//        for (j in 0 until N) {
//            val out = if (route[i][j]) "O" else "-"
//            print(out)
//        }
//        println()
//    }

    var count = 0
    for (num in 0 until N) {
        var hasOrder = true
        for (i in 0 until N) {
            if (num == i) continue
            if (!route[i][num] && !route[num][i]) {
                hasOrder = false
                break
            }
        }
        if (hasOrder) count++
    }
    println(count)
}