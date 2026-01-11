package acmicpc13265

import java.io.*
import java.util.*

/* 색칠하기, 이분 트리
https://www.acmicpc.net/problem/13265
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val st = StringTokenizer(bf.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val v = Array(n) { Vertex() }
        var binTreeCheckResult = true

        repeat(m) {
            val st = StringTokenizer(bf.readLine())
            val me = st.nextToken().toInt() - 1
            val you = st.nextToken().toInt() - 1
            v[me].neighbor.add(you)
            v[you].neighbor.add(me)
        }

        for (i in 0 until n) {
            if (v[i].color == 0) {
                binTreeCheckResult = setColor(i, v)
            }
            if (!binTreeCheckResult) {
                break
            }
        }

        when (binTreeCheckResult) {
            true -> sb.append("possible\n")
            false -> sb.append("impossible\n")
        }
    }
    print(sb)
}

private fun setColor(root : Int, v : Array<Vertex>) : Boolean {
    val q = ArrayDeque<State>()
    v[root].color = 1
    q.add(State(root, 1))
    while (q.isNotEmpty()) {
        val c = q.poll()
        for (i in v[c.cur].neighbor) {
            if (v[i].color == c.color) {
                return false
            }
            if (v[i].color == 0) {
                if (c.color == 1) {
                    v[i].color = 2
                } else {
                    v[i].color = 1
                }
                q.add(State(i, v[i].color))
            }
        }
    }

    return true
}
private data class State (val cur : Int, val color : Int)
private data class Vertex (var color : Int = 0, val neighbor : ArrayList<Int> = ArrayList())