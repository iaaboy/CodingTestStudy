package acmicpc25515

import java.io.*
import java.util.*

/* 트리 노드 합의 최댓값
https://www.acmicpc.net/problem/25515
 */

lateinit var nodes: Array<Node>
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()

    nodes = Array(n) { Node(0) }
    repeat(n - 1) {
        val st = StringTokenizer(bf.readLine())
        val p = st.nextToken().toInt()
        val s = st.nextToken().toInt()
        nodes[p].children.add(s)
    }

    val st = StringTokenizer(bf.readLine())
    for (i in 0..n - 1) {
        nodes[i].value = st.nextToken().toLong()
    }
    val vValue = nodes[0].getChild(true)
    println(vValue)
}

class Node(var value: Long) {
    val children = mutableListOf<Int>()
    fun getChild(isRoot: Boolean): Long {
        var childSum = 0L
        for (c in children) {
            val subSum = nodes[c].getChild(false)
            if (subSum > 0) {
                childSum += subSum
            }
        }
        if (value + childSum > 0) {
            return value + childSum
        } else if (value > 0 || isRoot) {
            return value
        } else {
            return 0
        }
    }
}

/*
8
0 1
0 2
1 3
1 4
2 5
2 6
6 7
-1 -1 -1 -1 -1 -1 -1 -1
 */

