package acmicpc22953

import java.io.*
import java.util.*

/* 도도의 음식 준비 , 이분탐색 매개변수 탐색
https://www.acmicpc.net/problem/22953
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val C = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    val chefs = LongArray(N) {
        st.nextToken().toLong()
    }

    fun meeCondition(arr: LongArray, cookTime: Long, K: Int): Boolean {
        var totalCook = 0L
        for (menuTime in arr) {
            totalCook += cookTime / menuTime
        }
        return totalCook >= K
    }

    fun search(): Long { // 최소 시간을 구한다.
        var left = 1L
        var right = Long.MAX_VALUE / (N.toLong() + 1L) //Total 개수 주의
        var answer = right
        while (left <= right) {
            val mid = (left + right) / 2L
            if (meeCondition(chefs, mid, K)) {
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return answer
    }

    var minTime = Long.MAX_VALUE
    fun combination(at: Int, depth: Int) {
        if (depth == C) {
            val result = search()
//            println("$result : ${chefs.joinToString(" ")}")
            minTime = minTime.coerceAtMost(result)
            return
        }
        for (i in at..<N) {
            if (chefs[i] > 1) {
                chefs[i]--
                combination(i, depth + 1)
                chefs[i]++
            } else {
                combination(i, depth + 1)
            }
        }
    }

    val result = search()
//    println("$result : ${chefs.joinToString(" ")}")
    minTime = minTime.coerceAtMost(result)

    combination(0, 0)

    println(minTime)
}
