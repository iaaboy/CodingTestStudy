package acmicpc34548

import java.io.*
import java.util.*

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
    val groupCounts = IntArray(T + 1)
    groupCounts[1] = groupCount
    for (edge in edges) {
        if (getUnion(edge.a) != getUnion(edge.b)) {
            setUnion(edge.a, edge.b)
            groupCount--
//            println("${edge.time} : $groupCount")
            groupCounts[edge.time] = groupCount
        }
    }
    var sum = 0
    for (i in 1..T) {
        if (groupCounts[i] == 0) {
            groupCounts[i] = groupCounts[i - 1]
        }
        sum += groupCounts[i]
    }

//    println(groupCounts.contentToString())
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