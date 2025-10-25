package acmicpc17127

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/* 벚꽃이 정보섬에 피어난 이유
https://www.acmicpc.net/problem/17127
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val nums = IntArray(N) { st.nextToken().toInt() }
    var maxNum = 0
    for (c1 in 1..N) {
        for (c2 in 1..N) {
            for (c3 in 1..N) {
                if (c1 + c2 + c3 > N - 1) continue
                val c4 = N - (c1 + c2 + c3)

                var total = 0
                var index = 0

                var count = c1
                var subSum = nums[index++]
                while (--count > 0) {
                    subSum *= nums[index++]
                }
                total += subSum

                count = c2
                subSum = nums[index++]
                while (--count > 0) {
                    subSum *= nums[index++]
                }
                total += subSum

                count = c3
                subSum = nums[index++]
                while (--count > 0) {
                    subSum *= nums[index++]
                }
                total += subSum

                count = c4
                subSum = nums[index++]
                while (--count > 0) {
                    subSum *= nums[index++]
                }
                total += subSum
                maxNum = Math.max(maxNum, total)
            }
        }
    }
    println(maxNum)
}