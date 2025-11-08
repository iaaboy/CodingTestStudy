package acmicpc34548

import java.io.*
import java.util.*

/* 와우 네트워크
https://www.acmicpc.net/problem/34548
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val T = st.nextToken().toInt()
    val edges = ArrayList<Edge>()
    repeat(M) {
        st = StringTokenizer(bf.readLine())
        edges.add(Edge(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1, st.nextToken().toInt()))
    }
    edges.sort()
    ids = IntArray(N) { it }
    var groupCount = N
    val groupCounts = ArrayList<IntArray>()
    groupCounts.add(intArrayOf(1, N))
    var prevHandled = 1
    for (edge in edges) {
        if (getUnion(edge.a) != getUnion(edge.b)) {
            setUnion(edge.a, edge.b)
            groupCount--
//            println("${edge.time} : $groupCount")
            if (prevHandled == edge.time) {
                groupCounts.last()[1] = groupCount
            } else {
                groupCounts.add(intArrayOf(edge.time, groupCount))
            }
            prevHandled = edge.time
        }
    }
    groupCounts.add(intArrayOf(T + 1, groupCount))

    var sum = 0L
    for (i in 1 until groupCounts.size) {
        val count = groupCounts[i - 1][1]
        val time = groupCounts[i][0] - groupCounts[i - 1][0]
        sum += count.toLong() * time.toLong()
    }
//    for (ints in groupCounts) {
//        print("${ints[0]} ${ints[1]} - ")
//    }

    println(sum)
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

data class Edge(val a: Int, val b: Int, val time: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return time - other.time
    }
}
