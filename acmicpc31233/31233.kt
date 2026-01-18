package acmicpc31233

import java.io.*
import java.util.*
import kotlin.math.max
import kotlin.math.min

/* 관광 상품, 애드혹
https://www.acmicpc.net/problem/31233
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val arr = IntArray(N) {
        st.nextToken().toInt()
    }
    var result = Int.MIN_VALUE
    for (start in 1 until N - 1) {
        val a = arr[start - 1]
        val b = arr[start]
        val c = arr[start + 1]
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            result = max(result, a)
        } else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            result = max(result, b)
        } else {
            result = max(result, c)
        }
    }

    if (N == 2) {
        result = min(arr[0],arr[1])
    }

    println(result)

}
