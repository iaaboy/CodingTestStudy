package acm.gold.acmicpc17250

import java.util.StringTokenizer

/* 은하철도, 분리 집합
https://www.acmicpc.net/problem/17250
 */

fun main() {
    val st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val ids = IntArray(N) {
        it
    }

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

    val planets = LongArray(N) {
        readln().toLong()
    }

    val sb = StringBuilder()
    repeat(M) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt() - 1
        val b = st.nextToken().toInt() - 1
        val uA = getUnion(a)
        val uB = getUnion(b)
        val planet = if (uA != uB) {
            planets[uA] += planets[uB]
            planets[uB] = planets[uA]
            setUnion(a, b)
            planets[uA]
        } else {
            planets[uA]
        }
        sb.append("$planet\n")
    }
    print(sb)
}
