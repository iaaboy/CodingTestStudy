package acm.gold.acmicpc1963

import java.util.StringTokenizer
import kotlin.math.pow

/* 소수 경로, 에라토스테네스의 체, 너비 우선 탐색.
https://www.acmicpc.net/problem/1963
 */

fun main() {
    val N = readln().toInt()
    val maxN = 10000
    val isNotPrime = BooleanArray(maxN + 1)
    isNotPrime[0] = true
    isNotPrime[1] = true
    for (i in 2..maxN / 2) {
        if (isNotPrime[i])
            continue
        var j = i * 2
        while (j <= maxN) {
            if (!isNotPrime[j]) {
                isNotPrime[j] = true
            }
            j += i
        }
    }

    val primes = ArrayList<Int>()
    for (i in 1000..9999) {
        if (!isNotPrime[i]) {
            primes.add(i)
        }
    }


    fun maskDigit(x: Int, i: Int): Int {
        val pow = 10.0.pow(i.toDouble()).toInt()
        return x - ((x / pow) % 10) * pow
    }

    var totalCount = -1
    var hasResult = false
    val visited = BooleanArray(10001)

    fun getNodeCount(nums: ArrayList<Int>, b: Int, count: Int) {
//        println(nums)
        if (hasResult) return
        val nextNums = ArrayList<Int>()
        for (a in nums) {
            for (switchIndex in 0..3) {
                val masked = maskDigit(a, switchIndex)
                for (i in 0..9) {
                    val refined = (masked + 10.0.pow(switchIndex) * i).toInt()
                    if (refined == a) continue
                    if (refined < 1000) continue
                    if (isNotPrime[refined]) continue
                    if (refined == b) {
                        hasResult = true
                        totalCount = count
                    } else {
                        if (!visited[refined]) {
                            visited[refined] = true
                            nextNums.add(refined)
                        }
                    }
                }
            }
        }
        if (nextNums.isNotEmpty()) {
            getNodeCount(nextNums, b, count + 1)
        }
    }

    val sb = StringBuilder()
    repeat(N) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if (a == b) {
            sb.append(0).append('\n')
        } else {
            val num = ArrayList<Int>()
            num.add(a)
            visited.fill(false)
            totalCount = -1
            hasResult = false
            getNodeCount(num, b, 1)
            sb.append(totalCount).append('\n')
        }
    }
    print(sb)
}