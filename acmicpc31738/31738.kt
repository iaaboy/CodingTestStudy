package acmicpc31738

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    var N = st.nextToken().toLong()
    val M = st.nextToken().toLong()
    var div = 1L

    if (N >= M) {
        println(0)
        return
    }

    while (N > 0) {
        div = (N*div) % M
        N--
    }
    println(div)
}