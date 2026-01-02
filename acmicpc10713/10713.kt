package acmicpc10713

import java.io.*
import java.util.*

/* 기차 여행 풀이, 누적합
https://www.acmicpc.net/problem/10713
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    val route = IntArray(M) {
        st.nextToken().toInt() - 1
    }
    val countUse = IntArray(N)
    for (i in 0 until M - 1) {
        val from = route[i].coerceAtMost(route[i + 1])
        val to = route[i].coerceAtLeast(route[i + 1])
        countUse[from]++
        countUse[to]--
    }
    var sum = 0
    for (i in 0 until N) {
        sum += countUse[i]
        countUse[i] = sum
    }

    val a = LongArray(N-1)
    val b = LongArray(N-1)
    val c = LongArray(N-1)
    for (i in 0 until N - 1) {
        st = StringTokenizer(bf.readLine())
        a[i] = st.nextToken().toLong()
        b[i] = st.nextToken().toLong()
        c[i] = st.nextToken().toLong()
    }

//    println(countUse.contentToString())
//    println(a.contentToString())
//    println(b.contentToString())
//    println(c.contentToString())

    val pay = LongArray(N - 1) {
        val index = it
        val ticketPrice = countUse[index].toLong() * a[index]
        val cardPrice = c[index] + countUse[index].toLong() * b[index]
        ticketPrice.coerceAtMost(cardPrice)
    }
    println(pay.sum())
}
