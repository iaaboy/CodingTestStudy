package acmicpc11758

import java.io.*
import java.util.*

/* CCW, ccw
https://www.acmicpc.net/problem/11758
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val x1 = st.nextToken().toInt()
    val y1 = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    val x2 = st.nextToken().toInt()
    val y2 = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    val x3 = st.nextToken().toInt()
    val y3 = st.nextToken().toInt()
    val ccw = ccw(x1, y1, x2, y2, x3, y3)
    val result = when {
        ccw > 0 -> 1
        ccw < 0 -> -1
        else -> 0
    }
    println(result)
}

private fun ccw(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Int {
    return (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)
}
