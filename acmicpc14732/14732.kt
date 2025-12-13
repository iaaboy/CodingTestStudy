package acmicpc14732

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val covered = Array(501) { BooleanArray(501) }

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()

        for (x in x1 until x2) {
            for (y in y1 until y2) {
                covered[x][y] = true
            }
        }
    }

    var area = 0
    for (x in 0..500) {
        for (y in 0..500) {
            if (covered[x][y]) area++
        }
    }

    println(area)
}