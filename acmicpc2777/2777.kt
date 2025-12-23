package acmicpc2777

import java.io.*

/* 숫자 놀이 풀이
https://www.acmicpc.net/problem/2777
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        var N = bf.readLine().toInt()
        val nums = ArrayList<Int>()
        while(N >= 10) {
            var canDiv = false
            for (i in 9 downTo  2) {
                if (N % i == 0) {
                    nums.add(i)
                    N /= i
                    canDiv = true
                    break
                }
            }

            if (!canDiv) {
                nums.clear()
                nums.add(-1)
                break
            }
        }
        if (N < 10) {
            nums.add(N)
        }
        if (nums[0] < 0) {
            sb.append("-1\n")
        } else {
            sb.append("${nums.size}\n")
        }
    }
    print(sb)
}