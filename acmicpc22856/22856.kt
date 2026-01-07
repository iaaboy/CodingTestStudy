package acmicpc22856

import java.io.*
import java.util.*

/* 트리 순회 , 트리
https://www.acmicpc.net/problem/22856
 */

var N = 0
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    N = bf.readLine().toInt()
    val v = ArrayList<Vertex>(N + 1)
    repeat(N + 1) {
        v.add(Vertex())
    }
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        val me = st.nextToken().toInt()
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()
        v[me].left = left
        v[me].right = right
        if (left > 0) v[left].parent = me
        if (right > 0) v[right].parent = me
    }
    visitNext(v, 1, false)
    println(count)
}
var count = 0
private fun visitNext(v: ArrayList<Vertex>, c: Int, needComeback : Boolean) {
    if (v[c].left > 0) {
        val next = v[c].left
        v[c].left = 0
        count++
//        println("$c -> $next")
        visitNext(v, next, true)
        count++
//        println("$next -> $c true")
    }
    // check Me
    if (v[c].right > 0) {
        val next = v[c].right
        v[c].right = 0
        count++
//        println("$c -> $next")
        visitNext(v, next, needComeback)
        if (needComeback)
            count++
//        println("$next -> $c $needComeback")
    }
}

private data class Vertex(var left: Int = 0, var right: Int = 0, var parent: Int = 0)
