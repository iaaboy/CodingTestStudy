package acmicpc24445

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val R = st.nextToken().toInt()
    val nodes = Array(N + 1) {
        ArrayList<Int>()
    }
    repeat(M) {
        val st = StringTokenizer(bf.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        nodes[start].add(end)
        nodes[end].add(start)
    }
    for (i in 1 .. N) {
        nodes[i].sortByDescending { it }
    }

    val visited = bfs(N, nodes, R)
    val sb = StringBuilder()
    for (i in 1 .. N) {
        sb.append("${visited[i]}\n")
    }
    print(sb)
}

var index = 1
fun bfs(N : Int, E: Array<ArrayList<Int>>, R: Int) : IntArray{
    val visited = IntArray(N + 1)
    val queue: ArrayDeque<Int> = ArrayDeque()
    queue.add(R)
    visited[R] = index++
    while (queue.isNotEmpty()) {
        val u = queue.removeFirst()
        // 인접 정점들을 내림차순으로 방문
        for (v in E[u]) {
            if (visited[v] == 0) {
                visited[v] = index++
                queue.add(v)
            }
        }
    }
    return  visited
}