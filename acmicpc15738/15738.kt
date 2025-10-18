package acmicpc15738

import java.io.*
import java.util.*

/* 뒤집기
https://www.acmicpc.net/problem/15738
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    var currentLocation = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    bf.readLine()
//    println("start -> $currentLocation")
    repeat(M) {
        val i = bf.readLine().toInt()
        when {
            i > 0 && currentLocation <= i -> {
                currentLocation = i - currentLocation + 1
            }

            i < 0 && currentLocation > N + i -> {
                currentLocation = 2 * N - currentLocation + i + 1
            }
        }
//        println("move $i -> $currentLocation")
    }
    println("$currentLocation")
}
/*
5 3 1
5 5 5 5 5
3
 */