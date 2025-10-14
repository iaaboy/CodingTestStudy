package acmicpc1676

import java.io.*
//import java.math.BigInteger

/* 팩토리얼 0의 개수
https://www.acmicpc.net/problem/1676
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var N = bf.readLine().toInt()
    var zeroCount = 0
//    getZeroCount(BigInteger(N.toString()))
    while (N > 1) {
        N /= 5
        zeroCount += N
    }
    println(zeroCount)
}

//private fun getZeroCount(N: BigInteger) {
//    var zeroCount = 0
//    for (ch in getFactorial(N).toString().reversed()) {
//        if (ch == '0') {
//            zeroCount++
//        } else {
//            break
//        }
//    }
//    println(zeroCount)
//}
//
//fun getFactorial(n: BigInteger): BigInteger {
//    if (n == BigInteger.ONE) {
//        return BigInteger.ONE
//    }
//    return n * getFactorial(n.minus(BigInteger.ONE))
//}