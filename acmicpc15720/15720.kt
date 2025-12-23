package acmicpc15720

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/* 카우버거 풀이
https://www.acmicpc.net/problem/15720
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val B = st.nextToken().toInt()
    val C = st.nextToken().toInt()
    val D = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    val burger = IntArray(B) {
        st.nextToken().toInt()
    }
    burger.sort()
    burger.reverse()
    st = StringTokenizer(bf.readLine())
    val sides = IntArray(C) {
        st.nextToken().toInt()
    }
    sides.sort()
    sides.reverse()
    st = StringTokenizer(bf.readLine())
    val beverages = IntArray(D) {
        st.nextToken().toInt()
    }
    beverages.sort()
    beverages.reverse()
    val setCount = B.coerceAtMost(C.coerceAtMost(D))
    var discount = 0
    for (i in 0 until setCount) {
        discount += burger[i] + sides[i] + beverages[i]
    }
    discount = discount * 10 / 100
    val cost = burger.sum() + sides.sum() + beverages.sum()
    println("$cost\n${cost - discount}")
}