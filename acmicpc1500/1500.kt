package acmicpc1500

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val S = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    var result = 1L
    if (S % K == 0) {
        repeat(K) {
            result *= (S/K).toLong()
        }
    } else {
        val div = (S / K).toLong()
        var remain = S % K
        repeat(K) {
            if (remain-- > 0) {
                result *= div + 1
            } else {
                result *= div
            }
        }
    }
    println(result)
}