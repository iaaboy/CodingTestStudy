package acmicpc31228

import java.io.*
import java.util.*
import kotlin.math.min

/*  실 전화기, 수학 GCD
https://www.acmicpc.net/problem/31228
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val d = gcd(N, K)
    val n = N / d
    var k = K / d

    k = min(k, n - k)

    val result = if (k <= 1) 0 else n * (k - 1)

    println(result)
}

private fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val t = x % y
        x = y
        y = t
    }
    return kotlin.math.abs(x)
}