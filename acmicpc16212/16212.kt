package acmicpc16212

import java.io.*
import java.util.*

/* 정열적인 정렬
https://www.acmicpc.net/problem/16212
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val arr = Array(N) { st.nextToken().toInt() }
    arr.sort()
    val sb = StringBuilder()
    for (i in arr) {
        sb.append(i).append(" ")
    }
    println(sb)
}