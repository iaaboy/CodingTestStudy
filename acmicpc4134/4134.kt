package acmicpc4134

import java.io.*

/* 다음 소수
https://www.acmicpc.net/problem/4134
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        var N = bf.readLine().toLong()
        while (true) {
            if (isPrime(N)) {
                sb.append(N).append(("\n"))
                break
            }
            N++
        }
    }
    print(sb)
}
fun isPrime(n: Long): Boolean {
    if (n < 2) return false
    if (n == 2L) return true
    if (n % 2L == 0L) return false

    var i = 3L
    while (i <= n / i) {
        if (n % i == 0L) return false
        i += 2L
    }
    return true
}
