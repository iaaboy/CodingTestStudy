package acmicpc27940

import java.io.*
import java.util.*
/* 가지 산사태
https://www.acmicpc.net/problem/27940
 */
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    var firstFloor = 0
    var count = -1
    for (m in 1 .. M) {
        val st = StringTokenizer(bf.readLine())
        st.nextToken().toInt()
        val r = st.nextToken().toInt()
        firstFloor += r
        if (firstFloor > K && count == -1) {
            count = m
        }
    }

    when (count == -1) {
        true -> println(-1)
        false -> println("$count 1")
    }
}