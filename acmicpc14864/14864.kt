package acmicpc14864

import java.io.*
import java.util.StringTokenizer

/* 순회강연, inversion 정보로 순열 복원, 애드혹
https://www.acmicpc.net/problem/2109
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val card = IntArray(N + 1)
    val exist = IntArray(N + 1)

    for (i in 1..N) {
        card[i] = i
    }

    // 관계 반영
    repeat(M) {
        val st2 = StringTokenizer(br.readLine())
        val x = st2.nextToken().toInt()
        val y = st2.nextToken().toInt()

        card[x]++
        card[y]--
    }

    for (i in 1..N) {
        if (card[i] < 1 || card[i] > N || exist[card[i]] == 1) {
            println(-1)
            return
        }
        exist[card[i]] = 1
    }

    val sb = StringBuilder()
    for (i in 1..N) {
        sb.append(card[i]).append(" ")
    }
    println(sb)
}
