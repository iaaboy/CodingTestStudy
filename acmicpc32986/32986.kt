package acmicpc32986

import java.util.StringTokenizer

/* 나는 건포도가 싫어요
https://www.acmicpc.net/problem/32986
 */

fun main() {
    val st = StringTokenizer(readLine())
    val numbs = Array(3) { st.nextToken().toInt() - 1 }
    numbs.sort()
    val count = when (numbs.all { it == 2 }) {
        true -> 0
        false -> numbs[0] / 2
    }
    println(count)
}