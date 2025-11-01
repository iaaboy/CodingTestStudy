package acmicpc28445

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.TreeSet

/* 알록달록 앵무새
https://www.acmicpc.net/problem/28445
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val colors = TreeSet<String>()
    colors.add(st.nextToken())
    colors.add(st.nextToken())
    st = StringTokenizer(bf.readLine())
    colors.add(st.nextToken())
    colors.add(st.nextToken())

    val sb = StringBuilder()
    for (st1 in colors) {
        for (st2 in colors) {
            sb.append("$st1 $st2\n")
        }
    }
    println(sb)
}