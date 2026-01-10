package acmicpc19240

import java.io.*
import java.util.*

/* 장난감 동맹군, 이분 그래프
https://www.acmicpc.net/problem/19240
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val K = bf.readLine().toInt()
    var isBinGraph : Boolean
    val sb = StringBuilder()
    (0..<K).forEach { _ ->
        var st = StringTokenizer(bf.readLine())
        val V = st.nextToken().toInt()
        val E = st.nextToken().toInt()
        isBinGraph = true
        val v = Array(V + 1) {
            Vertex()
        }
        for (i in 1..V) {
            v[i] = Vertex()
        }
        (0..<E).forEach { i ->
            st = StringTokenizer(bf.readLine())
            val me = st.nextToken().toInt()
            val you = st.nextToken().toInt()
            v[me].neighbors.add(you)
            v[you].neighbors.add(me)
        }
        MainLoop@ for (i in 1..V) {
            if (v[i].color == 0) {
                if (!setColor(v, i)) {
                    isBinGraph = false
                    continue@MainLoop
                }
            }
        }
//        println(v.contentToString())
        sb.append(if (isBinGraph) "YES\n" else "NO\n")
    }
    print(sb)
}

private fun setColor(v: Array<Vertex>, root: Int): Boolean {
    val q: Queue<State> = ArrayDeque<State>()
    v[root].color = 1
    q.add(State(root, 1))
    while (!q.isEmpty()) {
        val c = q.poll()
        for (n in v[c.id].neighbors) {
            if (v[n].color == c.color) {
                return false
            }
            if (v[n].color == 0) {
                if (c.color == 1) {
                    v[n].color = 2
                } else {
                    v[n].color = 1
                }

                q.add(State(n, v[n].color))
            }
        }
    }
    return true
}

internal class State(var id: Int, var color: Int)

internal class Vertex {
    var color: Int = 0
    var neighbors: ArrayList<Int> = ArrayList<Int>()

    override fun toString(): String {
        return "$color $neighbors"
    }
}
