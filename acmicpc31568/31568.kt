package acmicpc31568

import java.io.*
import java.util.*
import kotlin.math.max

/* 산림의 수호자, tree, dfs, treedp
https://www.acmicpc.net/problem/31568
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val v = Array(N) {
        Vertex(parent = it)
    }
    
    repeat(N - 1) {
        val st = StringTokenizer(bf.readLine())
        val a = st.nextToken().toInt() - 1
        val b = st.nextToken().toInt() - 1
        v[a].neighbor.add(b)
        v[b].neighbor.add(a)
    }

    val st = StringTokenizer(bf.readLine())
    val fire = st.nextToken().toInt() - 1
    val gs = st.nextToken().toInt() - 1
    val q = ArrayDeque<Int>()
    q.add(fire)

    while (q.isNotEmpty()) {
        val c = q.poll()
        if (c == gs) break
        for (son in v[c].neighbor) {
            if (v[son].parent == son) {
                v[son].parent = c
                q.add(son)
            }
        }
    }

    val history = ArrayList<Int>()
    var cur = gs
    while (cur != fire) {
        history.add(cur)
        cur = v[cur].parent
    }
    history.add(fire)

    val myStart = history.size / 2 - 1
    val myCut = myStart + 1

//    println("cut ${history[myStart]} ${history[myCut]}")
    v[history[myStart]].neighbor.remove(history[myCut])

    val visit = BooleanArray(N)
    for (i in 0 .. myStart) {
        visit[history[i]] = true
    }

    fun getSubMax(c: Int, v : Array<Vertex>, visit : BooleanArray): Int {
        var cur = 0
        for (son in v[c].neighbor) {
            if (!visit[son]) {
                visit[son] = true
                cur = max(cur, getSubMax(son, v, visit))
            }
        }
        return 1 + cur
    }

    var subMax = 0
    for (i in 0 .. myStart) {
        val sm = getSubMax(history[i], v, visit) - 1
//        println("${history[i]} $sm")
        subMax = max(subMax, sm)
    }

    println(myCut + subMax)

}

private data class Vertex(
    val neighbor : ArrayList<Int> = ArrayList(),
    var parent : Int
)