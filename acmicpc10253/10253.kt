package acmicpc10253

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val st = StringTokenizer(bf.readLine())
        var top = st.nextToken().toLong()
        var base = st.nextToken().toLong()
        while (top != 1L) {
            val rightBase = top * ((base / top) + 1)
            top = top * rightBase - top * base
            base = base * rightBase

            var gcd: Long = ucledianGcd(top, base)
            while (gcd > 1) {
                top /= gcd
                base /= gcd
                gcd = ucledianGcd(top, base)
            }
//            println("$top $base")
        }
        sb.append(base).append("\n")
    }
    print(sb)
}
private fun ucledianGcd(a: Long, b: Long): Long {
    var a = a
    var b = b
    while (b != 0L) {
        val r = a % b
        a = b
        b = r
    }
    return a
}