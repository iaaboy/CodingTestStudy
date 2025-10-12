package acmicpc20500

import java.io.BufferedReader
import java.io.InputStreamReader
//import java.math.BigInteger

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()

    val arr = Array(N + 3) {0L}
    arr[1] = 1L
    arr[2] = 1L
    for ((i, _) in arr.withIndex()) {
        if (i < 2) continue
        arr[i] = (arr[i-2] * 2 + arr[i-1]) % 1000000007
    }
//    println(arr.contentToString())
//    for(i in 1 .. N) {
//        makeN(StringBuilder(),i)
//        println("$i: $count  ${arr[i - 1]}")
//        count = 0
//    }
    println(arr[N - 1])
}
var count = 0
fun makeN(numberString : StringBuilder, n: Int) {
    if (n == 0) {
        if ((numberString.toString().toBigInteger().mod(15.toBigInteger()).equals(0.toBigInteger()) )) {
//            println(numberString)
            count++
        }
        return
    }
    makeN(StringBuilder(numberString).append('1') , n-1)
    makeN(StringBuilder(numberString).append('5') , n-1)
}