package acmicpc1630

import java.io.BufferedReader
import java.io.InputStreamReader

/* 오민식 풀이, 소수, 에라토스테네스의 체
https://www.acmicpc.net/problem/1630
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    if (N == 1) {
        println(1)
        return
    }

    val eratos = BooleanArray(N + 1)
    for (i in 2..N / 2) {
        var j = i * 2
        while (j <= N) {
            if (!eratos[j]) {
                eratos[j] = true // 소수가 아님.
            }
            j += i
        }
    }
    eratos[0] = true
    eratos[1] = true

    var num = 1L
    for (i in 1 .. N) {
        if (!eratos[i]) {
            var div = i.toLong()
            while (div * i <= N) {
                div *= i
            }
            num *= div
            num %= 987654321L
        }
    }

    println(num)

}