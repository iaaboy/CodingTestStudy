package acmicpc10775

import java.io.*

/* 공항, 분리집합 (union find)
https://www.acmicpc.net/problem/10775
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val G = bf.readLine().toInt()
    val P = bf.readLine().toInt()
    ids = IntArray(G + 1) {
        it
    }

//    println("\n${ids.joinToString(" ")}")

    var count = 0
    var blocked = false
    repeat(P) { _ ->
        val flight = bf.readLine().toInt()
        if (!blocked) {
            if (getUnion(flight) == 0) {
                //doNothing after blocked
                blocked = true
            } else {
                count++
                setUnion(flight, getUnion(flight) - 1)
            }
        }
//        println("$flight : ${getUnion(flight)} .. ${ids.joinToString(" ")}")
    }
    println(count)
}

private lateinit var ids: IntArray

private fun getUnion(from: Int): Int {
    var f = from
    while (ids[f] != f) {
        f = ids[f]
    }

    if (from != f) { // key !!! Union find 의 while loop를 줄임
        ids[from] = f
    }

    return f
}

private fun setUnion(from: Int, to: Int) {
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
