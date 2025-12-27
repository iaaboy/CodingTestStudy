package acmicpc14465

import java.io.*
import java.util.*

/* 소가 길을 건너간 이유 5, 누적합, 슬라이딩 윈도우
https://www.acmicpc.net/problem/14465
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val B = st.nextToken().toInt()
    val road = IntArray(N + 1)
    repeat(B) {
        val off = bf.readLine().toInt()
        road[off] = 1
    }
    var sum = 0
    for (i in 0 .. N) {
        sum += road[i]
        road[i] = sum
    }
    var min = Int.MAX_VALUE
    for (i in 1 .. N - K + 1) {
//        println("i:  $i")
        val repairNeed = road[i + K - 1] - road[i - 1]
        min = min.coerceAtMost(repairNeed)
    }
    println(min)
}