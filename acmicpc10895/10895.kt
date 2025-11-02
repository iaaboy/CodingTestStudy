package acmicpc10895

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
//import kotlin.math.pow

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val a = st.nextToken().toInt()
    val k = st.nextToken().toInt()

//    val result = customPow(1.toDouble(), a.toDouble(),k.toDouble() + 1)
//
//    println("$result ${result % (a + 1)}")

//    a -> 1 : 1
//
//    k -> 0 : a
//
//    a 짝수 : 1
//
//    k 홀수 : a

    if (a == 1) {
        println(1)
        return
    }
    if (k == 0) {
        println(a)
        return
    }

    when {
        a % 2 == 0 -> {
            println(1)
        }

        a % 2 == 1 -> {
            println(a)
        }
    }
}

//fun customPow(curVal: Double, a: Double, k: Double): Double {
//    if (k == 0.toDouble()) {
//        return curVal
//    }
//    return customPow(a.pow(curVal), a, k - 1)
//}
