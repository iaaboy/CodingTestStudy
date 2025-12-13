package acmicpc9659

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toLong()

    // N이 홀수면 SK, 짝수면 CY
    println(if (n % 2L == 1L) "SK" else "CY")
}
