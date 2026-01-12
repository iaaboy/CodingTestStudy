package acmicpc1068

import java.io.*
import java.util.*

/* 트리, 트리 너비 우선 탐색.
https://www.acmicpc.net/problem/1068
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val v = Array(N) {
        Vertex()
    }
    val st = StringTokenizer(bf.readLine())
    var root = 0
    for (son in 0 until N) {
        val parent = st.nextToken().toInt()
        if (parent != -1) {
            v[parent].node.add(son)
            v[son].p = parent
        } else {
            root = son
        }
    }
    val cut = bf.readLine().toInt()
    if (cut == root) {
        println(0)
        return
    }
    v[cut].node.clear()
    val cutsParent = v[cut].p
    if (cutsParent != -1) {
        v[cutsParent].node.remove(cut)
    }
    val q = ArrayDeque<Int>()
    q.add(root)
    while (q.isNotEmpty()) {
        val c = q.poll()
        if (v[c].node.isEmpty()) {
            leafCount++
        }
        for (son in v[c].node) {
            q.add(son)
        }
    }
    println(leafCount)
}

private var leafCount = 0

data class Vertex(var p: Int = -1, val node: ArrayList<Int> = ArrayList())