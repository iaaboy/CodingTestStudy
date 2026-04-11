package acm.gold.acmicpc16562

import java.util.StringTokenizer

/* 친구비, 누적합.
https://www.acmicpc.net/problem/16562
 */

fun main() {
    var st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val ids = IntArray(N) { it }


    fun getUnion(from: Int): Int {
        var f = from
        while (ids[f] != f) {
            f = ids[f]
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            ids[from] = f
        }

        return f
    }

    fun setUnion(from: Int, to: Int) {
        var f = from
        while (ids[f] != f) {
            f = ids[f]
        }
        var t = to
        while (ids[t] != t) {
            t = ids[t]
        }
        if (f > t) {
            ids[f] = t
        } else {
            ids[t] = f
        }
    }

    st = StringTokenizer(readln())
    val costs = LongArray(N) {
        st.nextToken().toLong()
    }

    repeat(M) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt() - 1
        val b = st.nextToken().toInt() - 1
        val uA = getUnion(a)
        val uB = getUnion(b)
        if (uA != uB) {
            setUnion(a, b)
        } else {
        }
    }
    for (i in 0..<N) {
        costs[getUnion(i)] = minOf(costs[i], costs[getUnion(i)])
    }
//    println(ids.joinToString(" "))
//    println(costs.joinToString(" "))
    var sum = 0L
    for (gId in ids.distinct()) {
        sum += costs[gId]
    }
    if (sum <= K) {
        println(sum)
    } else {
        println("Oh no")
    }
}