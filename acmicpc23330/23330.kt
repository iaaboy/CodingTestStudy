package acmicpc23330

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val arr = LongArray(n) {
        st.nextToken().toLong()
    }
    arr.sort()

    var prefix = 0L
    var pairSum = 0L

    for (i in arr.indices) {
        pairSum += arr[i] * i - prefix
        prefix += arr[i]
    }

    val ans = pairSum * 2
    println(ans)
}