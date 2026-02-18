package acmicpc20168

import java.io.*
import java.util.*

/* 골목 대장 호석 - 기능성, 깊이 우선 탐색 prunning
https://www.acmicpc.net/problem/20168
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val A = st.nextToken().toInt()
    val B = st.nextToken().toInt()
    val C = st.nextToken().toInt()
    val v = Array(N + 1) {
        Vertex()
    }

    repeat(M) {
        val st = StringTokenizer(bf.readLine())
        val from  = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        v[from].neighbor.add(Node(to, w))
        v[to].neighbor.add(Node(from, w))
    }

    val visit = BooleanArray(N + 1)
    var resultMin = Int.MAX_VALUE
    fun dfs (cur : Int, max : Int, sum : Int) {
        if (cur == B) {
//            println("$max $sum")
            resultMin = resultMin.coerceAtMost(max)
            return
        }
        for (node in v[cur].neighbor) {
            if (!visit[node.to]) {
                if (sum + node.weight > C) continue
                visit[node.to] = true
                dfs(node.to, max.coerceAtLeast(node.weight), sum + node.weight)
                visit[node.to] = false
            }
        }
    }
    visit[A] = true
    dfs(A, 0, 0)

    if (resultMin == Int.MAX_VALUE) resultMin = -1
    println(resultMin)
}
private class Vertex (val neighbor : ArrayList<Node> = ArrayList())
private data class Node(val to : Int, val weight : Int)
