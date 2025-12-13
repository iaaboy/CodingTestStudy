package acmicpc9763

import java.io.*
import java.util.*
import kotlin.math.abs

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val arr = Array(N) {
        val st = StringTokenizer(bf.readLine())
        Town(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
    }

    val best1 = IntArray(N) {
        Int.MAX_VALUE
    }
    val best2 = IntArray(N) {
        Int.MAX_VALUE
    }

    for (i in 0 until N) {
        for (j in i + 1 until N) {
            val d = dist(arr[i], arr[j])

            if (d < best1[i]) {
                best2[i] = best1[i]
                best1[i] = d
            } else if (d < best2[i]) {
                best2[i] = d
            }

            if (d < best1[j]) {
                best2[j] = best1[j]
                best1[j] = d
            } else if (d < best2[j]) {
                best2[j] = d
            }
        }
    }

    var answer = Int.MAX_VALUE
    for (i in 0 until N) {
        if (best2[i] != Int.MAX_VALUE) {
            val sum = best1[i] + best2[i]
            if (sum < answer) answer = sum
        }
    }

    println(answer)

}

fun dist(a: Town, b: Town): Int {
    return abs(a.x - b.x) + abs(a.y - b.y) + abs(a.z - b.z)
}

data class Town(val x : Int, val y : Int, val z : Int)