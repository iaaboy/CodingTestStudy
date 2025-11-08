package acmicpc16464

import java.io.BufferedReader
import java.io.InputStreamReader

/* 가주아
https://www.acmicpc.net/problem/16464
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val sb = StringBuilder()
    val twoPow = HashSet<Int>()
    var power2 = 1
    while (power2 <= 1000000000) {
        twoPow.add(power2)
        power2 *= 2
    }
    repeat(N) {
        val number = bf.readLine().toInt()
        when (!twoPow.contains(number)) {
            true -> sb.append("Gazua\n")
            else -> sb.append("GoHanGang\n")
        }
    }
    print(sb)

    println(twoPow)
}
