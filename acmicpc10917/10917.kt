package acmicpc10917

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val nodes = Array(N + 1) {
        ArrayList<Int>(0)
    }
    val visit = BooleanArray(N + 1)
    repeat(M) {
        val st = StringTokenizer(bf.readLine())
        nodes[st.nextToken().toInt()].add(st.nextToken().toInt())
    }
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(Pair(1, 0))
    visit[1] = true
    var distance = -1
    while (q.isNotEmpty()) {
        val cur = q.poll()
        if (cur.first == N) {
            distance = cur.second
            break
        }
        for (i in nodes[cur.first]) {
            if (!visit[i]) {
                visit[i] = true
                q.add(Pair(i, cur.second + 1))
            }
        }
    }
    println(distance)
}