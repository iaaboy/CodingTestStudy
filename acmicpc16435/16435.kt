package acmicpc16435

import java.io.*
import java.util.*

/* 스네이크버드
https://www.acmicpc.net/problem/16435
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    var L = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    val arr = IntArray(N) { st.nextToken().toInt() }
    arr.sort()
    for ((_, i) in arr.withIndex()) {
        if (L >= i) {
            L++
        }
    }
    println(L)
}