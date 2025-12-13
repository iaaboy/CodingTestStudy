package acmicpc9626

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val initialM = st.nextToken().toInt()
    val initialN = st.nextToken().toInt()

    st = StringTokenizer(bf.readLine())
    val U = st.nextToken().toInt()
    val L = st.nextToken().toInt()
    val R = st.nextToken().toInt()
    val D = st.nextToken().toInt()
    val M = initialM + (D + U)
    val N = initialN + (R + L)

    val arr = Array(M) {
        CharArray(N)
    }
    for (y in 0 until M) {
        var flip = y % 2 == 0
        for (x in 0 until N) {
            arr[y][x] = when (flip) {
                true -> '#'
                false -> '.'
            }
            flip = !flip
        }
    }
    for(y in 0 until initialM) {
        val charArray = bf.readLine().toCharArray()
        for ((index, ch) in charArray.withIndex()) {
            arr[y + U][index + L] = ch
        }
    }

    val sb = StringBuilder()
    for (chars in arr) {
        for (ch in chars) {
            sb.append(ch)
        }
        sb.append("\n")
    }
    print(sb)
}