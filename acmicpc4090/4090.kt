package acmicpc4090

import java.io.BufferedReader
import java.io.InputStreamReader

/* 뱀파이어 숫자, 이분탐색
https://www.acmicpc.net/problem/4090
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = 1020000
    val vampier = ArrayList<Int>()

    val count = IntArray(10)
    fun checkNum(left: Int, right: Int, num: Int): Boolean {
        var left = left
        var right = right
        var num = num
        for (i in count.indices) {
            count[i] = 0
        }

        // 왼쪽과 오른쪽 숫자의 각 자리수 빈도 증가
        while (left > 0) {
            count[left % 10]++
            left /= 10
        }
        while (right > 0) {
            count[right % 10]++
            right /= 10
        }

        // num의 각 자리수 빈도 감소
        while (num > 0) {
            count[num % 10]--
            num /= 10
        }

        // 모든 자리수 빈도가 0이면 같은 숫자 구성
        for (c in count) {
            if (c != 0) return false
        }
        return true
    }

    for (i in 1..N) {
        var right = 1
        while (right * right <= i) {
            if (i % right != 0) {
                right++
                continue
            }
            val left = i / right

            if (right > left) {
                right++
                continue
            }

            if (checkNum(left, right, i)) {
                vampier.add(i)
                break
            }
            right++
        }
    }

    val sb = StringBuilder()

    while (true) {
        val num = bf.readLine().toInt()
        if (num == 0) {
            break
        }
        for (i in vampier) {
            if (num <= i) {
                sb.append(i).append("\n")
                break
            }
        }
    }
    println(sb)
}
