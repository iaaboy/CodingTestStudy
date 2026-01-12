package acmicpc24391

import java.io.*
import java.util.*

/* 귀찮은 해강이, 분리 집합
https://www.acmicpc.net/problem/24391
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    ids = IntArray(N + 1) {
        it
    }
    repeat(M) {
        st = StringTokenizer(bf.readLine())
        val me = st.nextToken().toInt()
        val you = st.nextToken().toInt()
        setUnion(me, you)
    }
//    println(ids.contentToString())

    st = StringTokenizer(bf.readLine())
    var cur = st.nextToken().toInt()
    var wentOutCount = 0
    repeat(N - 1) {
        val next = st.nextToken().toInt()
        if (getUnion(cur) != getUnion(next)) {
            wentOutCount++
        }
        cur = next
    }
    println(wentOutCount)
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
