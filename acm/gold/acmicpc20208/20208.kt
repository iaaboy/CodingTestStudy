package acm.gold.acmicpc20208

import java.util.Stack
import java.util.StringTokenizer
import kotlin.math.abs

/* 진우의 민트초코우유, dfs 백트래킹
https://www.acmicpc.net/problem/20208
 */

fun main() {
    val st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val H = st.nextToken().toInt()
    val map = Array(N) {
        val st = StringTokenizer(readln())
        IntArray(N) {
            st.nextToken().toInt()
        }
    }

    val milks = ArrayList<Milk>()
    var sx = 0
    var sy = 0
    for (y in 0..<N) {
        for (x in 0..<N) {
            if (map[y][x] == 2) {
                milks.add(Milk(y, x))
            } else if (map[y][x] == 1) {
                sx = x
                sy = y
            }
        }
    }


    val size = milks.size
    val visit = BooleanArray(size)
    val history = Stack<Int>()

//    for (i in 0..<size) {
//        print("$i ${milks[i]} , ")
//    }
//    println()

    var maxCount = 0
    fun dfs(y: Int, x: Int, health: Int, depth: Int) {
//        println("$y $x $health $depth ${history}")

        val distanceToHome = abs(x - sx) + abs(y - sy)
        if (health - distanceToHome >= 0) {
            maxCount = maxOf(maxCount, depth)
        }

        if (depth == size) {
            return
        }

        for (i in 0..<size) {
            if (!visit[i]) {
                visit[i] = true
                val distance = abs(y - milks[i].y) + abs(x - milks[i].x)
//                println("${milks[i]} : $health $distance")
                if (health - distance >= 0) {
                    history.add(i)
                    dfs(milks[i].y, milks[i].x, health - distance + H, depth + 1)
                    history.pop()
                }
                visit[i] = false
            }
        }
    }

    dfs(sy, sx, M, 0)
    println(maxCount)
}

data class Milk(val y: Int, val x: Int)

