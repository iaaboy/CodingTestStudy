package acmicpc13023

import java.io.*
import java.util.*

/* ABCDE, 너비 우선 탐색
https://www.acmicpc.net/problem/13023
 */

lateinit var relation: Array<HashSet<Int>>
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    relation = Array(N) {
        HashSet<Int>()
    }
    repeat(M) {
        st = StringTokenizer(bf.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        relation[from].add(to)
        relation[to].add(from)
    }

    for (i in 0..<N) {
        val visited = BooleanArray(N)
        visited[i] = true
        dfs(visited, i, 0)
    }

    println(result)
}

var result = 0
private fun dfs(visited: BooleanArray, cur: Int, depth: Int) {
//    println("$cur $depth")
    if (result == 1) {
        return
    }
    if (depth == 4) {
        result = 1
        return
    }
    for (son in relation[cur]) {
        if (!visited[son]) {
            visited[son] = true
            dfs(visited, son, depth + 1)
            visited[son] = false
        }
    }
}