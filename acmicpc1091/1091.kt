package acmicpc1091

import java.io.*
import java.util.*

/* 카드 섞기 , 구현
https://www.acmicpc.net/problem/1091
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    var st = StringTokenizer(bf.readLine())
    val targetOrder = IntArray(N) { st.nextToken().toInt() }
    st = StringTokenizer(bf.readLine())
    val suffleOrder = IntArray(N) { st.nextToken().toInt() }
    val initialOrder = IntArray(N) {
        it % 3
    }
    var currentOrder = initialOrder.clone()

    for (count in 0 .. 10000000){
        if (currentOrder.contentEquals(targetOrder)) {
            println(count)
            return
        } else if (count != 0 && currentOrder.contentEquals(initialOrder)) {
            println(-1)
            return
        }
        currentOrder = shuffle(N, currentOrder, suffleOrder)
//        println(currentOrder.contentToString())
    }
}
fun shuffle (n : Int, cOrder : IntArray, shuffle : IntArray) : IntArray {
    val newOrder = IntArray(n)
    for (i in 0 until n) {
        newOrder[i] = cOrder[shuffle[i]]
    }
    return newOrder
}