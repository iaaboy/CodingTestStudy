package acm.gold.acmicpc27066

import java.util.StringTokenizer

/* 나무 블럭 게임, 그리디 정렬
https://www.acmicpc.net/problem/27066
 */

fun main() {
    val N = readln().toInt()
    val st = StringTokenizer(readln())
    val array = IntArray(N) { st.nextToken().toInt() }
    val avr = array.average()
    array[array.indexOf(array.max())] = -1
    val mid = array.max().toDouble()
    println(maxOf(mid, avr))
}
