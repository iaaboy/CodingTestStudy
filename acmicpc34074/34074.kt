package acmicpc34074

import java.io.*
import java.util.*

/* 리오와 리쿠의 대난투, 애드혹 해구성하기
https://www.acmicpc.net/problem/34074
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    if (N == 1 && M == 1) {
        println(-1)
        return
    }

    if (N == 1 && M == 2) {
        println("3")
        println("1 4")
        return
    }

    val A = ArrayList<Long>()
    val B = ArrayList<Long>()

    if (N == 1 && M >= 3) {
        A.add(M.toLong())
        for (i in 1 .. M - 1) {
            B.add(i.toLong())
        }
        B.add(1000000000L)
    } else {
        for (i in 1 .. N-1) {
            A.add(i.toLong())
        }
        A.add(1000000000L)
        for (i in 0 .. M-1) {
            B.add((N + i).toLong())
        }
    }

    println(A.joinToString(" "))
    println(B.joinToString(" "))
}
