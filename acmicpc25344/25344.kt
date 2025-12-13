package acmicpc25344

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt() - 2
    val st = StringTokenizer(bf.readLine())
    val arr = LongArray(N) {
        st.nextToken().toLong()
    }
    var result = arr[0]
    for (i in 1 until arr.size) {
        result = lcm(result, arr[i])
    }
    println(result)
}

private fun gcd(a: Long, b: Long): Long {
    var a = a
    var b = b
    while (b != 0L) {
        val r = a % b
        a = b
        b = r
    }
    return a
}

fun lcm(a: Long, b: Long): Long {
    return a / gcd(a, b) * b
}