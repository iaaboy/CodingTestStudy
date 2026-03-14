package acmicpc11662

import java.io.*
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

/* 민호와 강호, 삼분 탐색.
https://www.acmicpc.net/problem/11662
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val Ax = st.nextToken().toInt()
    val Ay = st.nextToken().toInt()
    val Bx = st.nextToken().toInt()
    val By = st.nextToken().toInt()
    val Cx = st.nextToken().toInt()
    val Cy = st.nextToken().toInt()
    val Dx = st.nextToken().toInt()
    val Dy = st.nextToken().toInt()

    fun distance(t: Double): Double {
        val mx = Ax + (Bx - Ax) * t
        val my = Ay + (By - Ay) * t
        val kx = Cx + (Dx - Cx) * t
        val ky = Cy + (Dy - Cy) * t
        return sqrt((ky - my).pow(2) + (kx - mx).pow(2))
    }

    var l = 0.0
    var r = 1.0

    repeat(100) {
        val m1 = (2 * l + r) / 3
        val m2 = (l + 2 * r) / 3

//        println("$m1 $m2")

        if (distance(m1) < distance(m2)) r = m2
        else l = m1
    }

    println(distance((l + r) / 2))
}
