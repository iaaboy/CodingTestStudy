package acmicpc1600

import java.io.*
import java.util.*

/*
TODO
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val k = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()
    val map = Array(h) { IntArray(w) }
    for (y in 0 until h) {
        val st = StringTokenizer(bf.readLine())
        for (x in 0 until w) {
            map[y][x] = st.nextToken().toInt()
        }
    }
    val dpCost = Array(k) { Array(h) { IntArray(w) { -1 } } }
    val dpHorseCount = Array(k) { Array(h) { IntArray(w) { k } } }
    val d = arrayOf(Node(1, 0), Node(-1, 0), Node(0, 1), Node(0, -1))
    val horse = arrayOf(
        Node(1, 2), Node(2, 1), Node(1, -2), Node(2, -1),
        Node(-1, 2), Node(-2, 1), Node(-1, -2), Node(-2, -1)
    )

    val q = ArrayDeque<Node>()
    q.add(Node(0, 0))
    while (q.isNotEmpty()) {
        val c = q.poll()
        if (c.y == h - 1 && c.x == w - 1) {
            break
        }
        for (node in d) {
            val nx = c.x + node.x
            val ny = c.y + node.y
            if (checkRange(ny, nx, w, h)) continue

        }
        for (node in horse) {
            val nx = c.x + node.x
            val ny = c.y + node.y
            if (checkRange(ny, nx, w, h)) continue

            //...

        }
    }
    println(dpCost[h - 1][w - 1])
}

fun checkRange(y: Int, x: Int, w: Int, h: Int) = y > 0 && x > 0 && x <= w && y <= h

data class Node(
    val y: Int,
    val x: Int,
    var cost: Int = 0,
    var horse: Int = 0
)