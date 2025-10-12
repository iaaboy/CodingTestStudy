package acmicpc1863

import java.io.*
import java.util.*

/* 스카이라인 쉬운거
https://www.acmicpc.net/problem/1863
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val arr = Array(N) { IntArray(2) }
    for (i in 0 until N) {
        val st = StringTokenizer(bf.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        arr[i][0] = x
        arr[i][1] = y
    }
    arr.sortWith(compareBy { it[0] })
    var buildingCount = 0
    val pq = Stack<Int>()
    for (ints in arr) {
        while (!pq.isEmpty() && pq.peek() > ints[1]) {
            pq.pop()
            buildingCount++
        }
        if (pq.isEmpty() || pq.peek() != ints[1]) {
            pq.add(ints[1])
        }
    }
    while (!pq.isEmpty()) {
        if (pq.peek() != 0)
            buildingCount++
        pq.pop()
    }
    println(buildingCount)
}