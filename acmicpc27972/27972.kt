package acmicpc27972

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val arr = IntArray(N) {
        st.nextToken().toInt()
    }
    var maxChange = 1
    var upCount = 1
    var downCount = 1
    for (i in 1 until N) {
        when {
            arr[i] > arr[i - 1] -> {
                upCount++
                downCount = 1
            }

            arr[i] < arr[i - 1] -> {
                upCount = 1
                downCount++
            }
        }
        maxChange = maxChange.coerceAtLeast(upCount)
        maxChange = maxChange.coerceAtLeast(downCount)
    }
    println(maxChange)
}