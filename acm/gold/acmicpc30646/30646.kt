package acm.gold.acmicpc30646

import java.util.StringTokenizer

/* 최대 합 순서쌍의 개수 , 누적합 집합과 맵
https://www.acmicpc.net/problem/30646
 */

fun main() {
    val N = readln().toInt()
    val st = StringTokenizer(readln())
    var sum = 0L
    val array = IntArray(N) {
        st.nextToken().toInt()
    }
    val sumArray = LongArray(N) {
        sum += array[it].toLong()
        val num = sum
        num
    }
    val firstIndex = HashMap<Int, Int>()

    fun getSum(start: Int, end: Int): Long {
        if (start == 0) {
            return sumArray[end]
        } else {
            return sumArray[end] - sumArray[start - 1]
        }
    }

    var max = array.max().toLong()
    var maxCount = array.count { max.toInt() == it }

    for (i in 0..<N) {
        val fIdx = firstIndex.getOrDefault(array[i], -1)
        if (fIdx == -1) {
            firstIndex[array[i]] = i
        } else {
            val curSum = getSum(firstIndex[array[i]] ?: 0, i)
            if (max == curSum) {
                maxCount++
            } else if (max < curSum) {
                max = curSum
                maxCount = 1
            }
        }
    }
    println("$max $maxCount")
}
