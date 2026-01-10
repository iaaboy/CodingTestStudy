package acmicpc2250

import java.io.*
import java.util.*

/* 트리의 높이와 너비, 그래프 탐색.
https://www.acmicpc.net/problem/2250
 */

var N = 0
private lateinit var v: ArrayList<Vertex>
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    N = bf.readLine().toInt()
    v = ArrayList<Vertex>(N + 1)
    repeat(N + 1) {
        v.add(Vertex())
    }
    val hasParent = BooleanArray(N + 1)
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        val me = st.nextToken().toInt()
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()
        v[me].left = left
        v[me].right = right
        if (left > 0) {
            v[left].parent = me
            hasParent[left] = true
        }
        if (right > 0) {
            v[right].parent = me
            hasParent[right] = true
        }
    }

    var root = 1
    for (i in 1 .. N) {
        if (!hasParent[i]) root = i
    }

    visitNext(root, 1)

//    for ((index, vertex) in v.withIndex()) {
//        println("$index : $vertex")
//    }

    val floors = Array<Floor> (maxDepth + 1) {
        Floor()
    }
    for (i in 0 .. N) {
        floors[v[i].depth].max = floors[v[i].depth].max.coerceAtLeast(v[i].id)
        floors[v[i].depth].min = floors[v[i].depth].min.coerceAtMost(v[i].id)
    }
//    println(floors.contentToString())
    var maxFloor = 1
    for (index in 1 .. maxDepth) {
        if (floors[index].max - floors[index].min > floors[maxFloor].max - floors[maxFloor].min) {
            maxFloor = index
        }
    }
    println("$maxFloor ${floors[maxFloor].max - floors[maxFloor].min + 1}")
}

private data class Floor (var min : Int = Int.MAX_VALUE, var max: Int = Int.MIN_VALUE)

var count = 1
var maxDepth = 0
private fun visitNext(c: Int, depth: Int) {
    maxDepth = maxDepth.coerceAtLeast(depth)
    if (v[c].left > 0) {
        val next = v[c].left
        v[c].left = 0
        visitNext(next, depth + 1)
        setId(v, c, depth)
    }
    setId(v, c, depth)
    if (v[c].right > 0) {
        val next = v[c].right
        v[c].right = 0
        visitNext(next, depth + 1)
        setId(v, c, depth)
    }
}

private fun setId(v: ArrayList<Vertex>, c: Int, depth: Int) {
    if (v[c].id == -1) {
        v[c].id = count++
        v[c].depth = depth
    }
}

private data class Vertex(
    var left: Int = 0,
    var right: Int = 0,
    var parent: Int = 0,
    var id: Int = -1,
    var depth: Int = 0
)
