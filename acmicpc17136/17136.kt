package acmicpc17136

import java.io.*
import java.util.*
import kotlin.math.min

/* 색종이 붙이기, 백트래킹
https://www.acmicpc.net/problem/17136
 */

lateinit var map : Array<IntArray>
var totalCount = 0
val N = 10
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    map = Array(N) {
        val st = StringTokenizer(bf.readLine())
        IntArray(N) {
            val num = st.nextToken().toInt()
            if (num == 1) totalCount++
            num
        }
    }

    if (totalCount == 0) {
        println(0)
        return
    }

    for (y in 0 until N) {
        for (x in 0 until N) {
            if (map[y][x] == 1) {
                val paperUsed = IntArray(6) {
                    5
                }
                handle(y,x, totalCount, 0, paperUsed)
                break
            }
        }
    }

    if (minCount == Int.MAX_VALUE) minCount = -1
    println(minCount)
}
var minCount = Int.MAX_VALUE
private fun handle(iY : Int, iX : Int, remained : Int, coveredCount : Int, paperUsed : IntArray) {
    if (coveredCount >= minCount) return
    if (remained == 0) {
//        println("$iY $iX ${coveredCount} done")
        minCount = min(minCount, coveredCount)
        return
    }

    val start = iY * N + iX

    for (idx in start until N * N) {
        val y = idx / N
        val x = idx % N

        if (map[y][x] == 0) continue

        for (size in 1 .. 5) {
            if (paperUsed[size] <= 0) continue
            if (checkAllOne(y, x, size)) {
                fill(y, x, size, 0)
                paperUsed[size]--
                handle(y, x, remained - (size * size), coveredCount + 1, paperUsed)
                paperUsed[size]++
                fill(y, x, size, 1)
            }
        }

        return
    }
}

private fun checkAllOne(y: Int, x: Int, size: Int): Boolean {
    if (y + size > N || x + size > N) return false
    for (i in y ..< y + size) {
        for (j in x ..< x + size) {
            if (map[i][j] != 1) return false
        }
    }
    return true
}

private fun fill(y: Int, x: Int, size: Int, value : Int){
    for (i in (y until y + size)) {
        for (j in (x until x + size)) {
            map[i][j] = value
        }
    }
}
