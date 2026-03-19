package acmicpc1914

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

/* 하노이 탑, 큰수 연산, 재귀.
https://www.acmicpc.net/problem/1914
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val sb = StringBuilder()
    var count = 0L

    fun hanoi(n: Int, from: Int, aux: Int, to: Int) {
        if (n == 1) {
            count++
            sb.append(from).append(" ").append(to).append("\n")
            return
        }
        hanoi(n - 1, from, to, aux)
        count++
        sb.append(from).append(" ").append(to).append("\n")
        hanoi(n - 1, aux, from, to)
    }

    if (N <= 20) {
        hanoi(N, 1, 2, 3)
        sb.insert(0, count.toString() + "\n")
    } else {
        val result = BigInteger(2.toString()).pow(N).minus(BigInteger.ONE)
        sb.insert(0, result.toString() + "\n")
    }

    print(sb)
}
