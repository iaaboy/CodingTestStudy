package acmicpc17352

import java.io.*
import java.util.*

/* 여러분의 다리가 되어 드리겠습니다! , 분리 집합
https://www.acmicpc.net/problem/17352
 */

lateinit var ids : IntArray
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    ids = IntArray(N) {
        it
    }
    repeat(N - 2) {
        val st = StringTokenizer(bf.readLine())
        setUnion(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1)
    }
    val first = getUnion(0)
    for (i in 1 until N) {
        val second = getUnion(i)
        if (first != second) {
            println("${first + 1} ${getUnion(i) + 1}")
            break
        }
    }
}

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