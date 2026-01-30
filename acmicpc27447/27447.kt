package acmicpc27447

import java.io.*
import java.util.*
import kotlin.math.max

/* 주문은 토기입니까?, Union find.
https://www.acmicpc.net/problem/27447
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    var maxN = 0
    val arrivalTimes = IntArray(N) {
        val arrivalTime = st.nextToken().toInt()
        maxN = max(arrivalTime, maxN)
        arrivalTime
    }
    val tasks = IntArray(maxN + 1)
    val spaceAvailable = IntArray(maxN + 1) {
        it
    }
    for (ar in arrivalTimes.reversed()) {
        tasks[ar] = 1
        spaceAvailable[ar] = ar - 1
    }

//    println(tasks.joinToString(" "))

    fun getAvailable(x: Int): Int {
        if (x < 0) return -1
        if (spaceAvailable[x] == x) return x
        spaceAvailable[x] = getAvailable(spaceAvailable[x])
        return spaceAvailable[x]
    }

    for (ar in arrivalTimes.reversed()) {
        val availableSpace = getAvailable(ar - 1)
        if (availableSpace < 1) {
            println("fail")
            return
        }
        tasks[availableSpace] = 2
        spaceAvailable[availableSpace] = getAvailable(availableSpace - 1)
        if (ar - availableSpace > M) {
            println("fail")
            return
        }
    }

//    for (i in 0 .. maxN) {
//        print(" $i")
//    }

    var togiCount = 0
    for (t in tasks) {
        if (t == 0) {
            togiCount++
        } else if (t == 2) {
            togiCount--
        }
        if (togiCount < 0) {
            println("fail")
            return
        }
    }

    println("success")
//    println(tasks.joinToString(" "))
//    println(spaceAvailable.joinToString(" "))
}


