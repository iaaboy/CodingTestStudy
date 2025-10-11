package acmicpc2258

import java.io.*
import java.util.*

/* 정육점
https://www.acmicpc.net/problem/2258
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toLong()

    val arr = Array(N) { IntArray(2) }

    for (i in 0..N - 1) {
        st = StringTokenizer(bf.readLine())
        arr[i][0] = st.nextToken().toInt()
        arr[i][1] = st.nextToken().toInt()
    }

    arr.sortWith(
        compareBy<IntArray> { it[1] }          // 첫 번째: 오름차순
            .thenByDescending { it[0] }        // 두 번째: 내림차순
    )

    var sum = 0L
    var previousPrice = -1
    var priceAccumulate = 0L
    var minPrice = Long.MAX_VALUE
    for ((_, ints) in arr.withIndex()) {
        sum += ints[0]
        if (previousPrice == ints[1]) {
            priceAccumulate += ints[1]
        } else {
            previousPrice = ints[1]
            priceAccumulate = ints[1].toLong()
        }
//        println("$sum $priceAccumulate ${ints[0]} ${ints[1]} ")
        if (sum >= M) {
            minPrice = minPrice.coerceAtMost(priceAccumulate)
        }
    }
    if (minPrice == Long.MAX_VALUE) minPrice = -1
    println("$minPrice")
}

/*
10 14
3 1
2 3
1 3
7 3
10 3
2 4
8 4
2 5
7 9
3 10
4

3 8
4 2
4 2
1 4
4

4 3
1 2
3 2
2 2
5 7
2
 */