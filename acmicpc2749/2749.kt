package acmicpc2749

import java.io.*

/* 피보나치 수 3, fast doubling
https://www.acmicpc.net/problem/2749
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toLong()

    println(fib(N, 1000000L))
}

fun fib(n: Long, mod: Long): Long {
    return fibPair(n, mod).first
}

fun fibPair(n: Long, mod: Long): Pair<Long, Long> {
    if (n == 0L) return 0L to 1L

    val (a, b) = fibPair(n / 2, mod)

    val c = (a * ((2 * b % mod - a + mod) % mod)) % mod
    val d = (a * a % mod + b * b % mod) % mod

    return if (n % 2 == 0L) {
        c to d
    } else {
        d to (c + d) % mod
    }
}
