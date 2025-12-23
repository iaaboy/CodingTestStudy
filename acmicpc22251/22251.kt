package acmicpc22251

import java.io.*
import java.util.StringTokenizer

/* 빌런 호석 풀이
https://www.acmicpc.net/problem/22251
 */

val imageMap = HashMap<Int, Int>()
val switchCosts = Array(10) {
    IntArray(10)
}

fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt() // 1 ~ N
    val K = st.nextToken().toInt() // 자리수
    val P = st.nextToken().toInt() //P개 반전
    val X = st.nextToken().toInt() //현재 X층

    imageMap.put(0, 0b1111110)
    imageMap.put(1, 0b0110000)
    imageMap.put(2, 0b1101101)
    imageMap.put(3, 0b1111001)
    imageMap.put(4, 0b0110011)
    imageMap.put(5, 0b1011011)
    imageMap.put(6, 0b1011111)
    imageMap.put(7, 0b1110000)
    imageMap.put(8, 0b1111111)
    imageMap.put(9, 0b1111011)

    for (i in 0..9) {
        for (j in 0..9) {
            val a = imageMap.getOrDefault(i, 0)
            val b = imageMap.getOrDefault(j, 0)
            val aXorB = a.xor(b).toString(2).count { ch -> ch == '1' }
            switchCosts[i][j] = aXorB
        }
    }
    val me = X.getFixedIntArray(K)
    var countAvailable = 0
    for (i in 1..N) {
        val numArray = i.getFixedIntArray(K)
        val flipCount = calculateFilpCount(me, numArray)
        if (flipCount != 0 && flipCount <= P) {
            countAvailable++
        }
//        println("$i .. $flipCount")
    }
    println(countAvailable)
}

fun calculateFilpCount(me: IntArray, you: IntArray): Int {
    var totalCost = 0
    for ((index, myNum) in me.withIndex()) {
        totalCost += switchCosts[myNum][you[index]]
    }
    return totalCost
}

private fun Int.getFixedIntArray(length: Int): IntArray {
    val result = IntArray(length)
    var myNum = this
    for (i in length - 1 downTo 0) {
        result[i] = (myNum % 10)
        myNum /= 10
    }
    return result
}
