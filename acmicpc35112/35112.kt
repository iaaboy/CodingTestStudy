package acmicpc35112

import java.io.*
import java.util.*

/* 으악그래프, 그래프 이론
https://www.acmicpc.net/problem/35112
 */


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    if (M <= N) println("Yes")
    else println("No")
}
