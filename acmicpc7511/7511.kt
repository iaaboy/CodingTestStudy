package acmicpc7511

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    for (t in 1 .. T) {
        val N = bf.readLine().toInt()
        ids = IntArray(N) {
            it
        }
        val K = bf.readLine().toInt()
        repeat(K) {
            val st = StringTokenizer(bf.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            setUnion(a,b)
        }
        val M = bf.readLine().toInt()
        sb.append("Scenario $t:\n")
        repeat(M) {
            val st = StringTokenizer(bf.readLine())
            val me = st.nextToken().toInt()
            val you = st.nextToken().toInt()
            if (getUnion(me) == getUnion(you)) {
                sb.append(1)
            } else {
                sb.append(0)
            }
            sb.append("\n")
        }
        sb.append("\n")
    }
    print(sb)
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