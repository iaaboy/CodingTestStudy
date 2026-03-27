package acmicpc10836

import java.io.*
import java.util.*

/* 여왕벌, 누적합.
https://www.acmicpc.net/problem/10836
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val M = st.nextToken().toInt()
    val N = st.nextToken().toInt()
    val arr = IntArray(M * 2)
    repeat(N) {
        st = StringTokenizer(bf.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        arr[a]++
        arr[a + b]++
    }

    var sum = 1
    for (i in arr.indices) {
        sum += arr[i]
        arr[i] = sum
    }
//    println(arr.joinToString(" "))

    val horizontal = IntArray(M)
    val vertical = IntArray(M)
    for (i in 0..<M) {
        vertical[M - 1 - i] = arr[i]
        horizontal[i] = arr[i + M - 1]
    }

//    println(horizontal.joinToString(" "))
//    println(vertical.joinToString(" "))

    val sb = StringBuilder()
    for (y in 0..<M) {
        for (x in 0..<M) {
            if (x == 0) {
                horizontal[x] = vertical[y]
            } else if (y == 0) {
                //그대로 .. horizontal[x]
            } else {
                //좌왼위 최대값
                horizontal[x] = maxOf(horizontal[x], horizontal[x - 1])
            }
            sb.append("${horizontal[x]} ")
        }
        sb.append("\n")
    }
    print(sb)
}
