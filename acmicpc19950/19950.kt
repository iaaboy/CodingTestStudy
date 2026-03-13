package acm19950

import java.io.*
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.max

/* 3차원 막대기 연결하기, 그리디
https://www.acmicpc.net/problem/19950
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val x1 = st.nextToken().toInt()
    val y1 = st.nextToken().toInt()
    val z1 = st.nextToken().toInt()
    val x2 = st.nextToken().toInt()
    val y2 = st.nextToken().toInt()
    val z2 = st.nextToken().toInt()

    val n = br.readLine().toInt()

    st = StringTokenizer(br.readLine())

    var sum = 0
    var maxStick = 0

    repeat(n) {
        val v = st.nextToken().toInt()
        sum += v
        maxStick = max(maxStick, v)
    }

    val dist = abs(x1-x2) + abs(y1-y2) + abs(z1-z2)

    if (sum >= dist && maxStick <= sum - maxStick + dist)
        println("YES")
    else
        println("NO")
}