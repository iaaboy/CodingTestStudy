package acm.gold.acmicpc29768

import java.util.StringTokenizer

/* 팰린드롬 이름, 애드혹 해구성하기.
https://www.acmicpc.net/problem/29768
 */

fun main() {
    val st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val answer = CharArray(N) {
        'a'
    }
    var alpha = 'a'
    for (i in N - M..<N) {
        answer[i] = alpha++
    }
    val sb = StringBuilder()
    for (ch in answer) {
        sb.append(ch)
    }
    println(sb)
}