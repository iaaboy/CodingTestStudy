package acmicpc23562

import java.io.*
import java.util.*

/* ㄷ 만들기, 구현
https://www.acmicpc.net/problem/23562
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val map = Array(N) {
        bf.readLine().toCharArray()
    }

    fun makeDigud(line : Int) : Array<CharArray> {
        val digud = Array(line * 3) {
            if (it < line) {
                CharArray(line * 3) {'#'}
            } else if (it > line * 3 - line - 1){
                CharArray(line * 3) {'#'}
            } else {
                CharArray(line * 3) {'.'}
            }
        }

        for (x in 0 until line) {
            for (y in 0 until line * 3) {
                digud[y][x] = '#'
            }
        }

        return digud
    }
    val maxVal = minOf(N, M) / 3
    val canvas = Array(N) { CharArray(M) { '.' } }

    fun drawCanvas (sy : Int, sx : Int, d : Array<CharArray> ) {
        val size = d.size
        for (y in 0 until size) {
            for (x in 0 until size) {
                canvas[y + sy][x + sx] = d[y][x]
            }
        }
    }
    fun getCost () : Int {
        var cost = 0
        for (y in 0 until N) {
            for (x in 0 until M) {
                if (map[y][x] == canvas[y][x]) continue
                if (map[y][x] == '.') {
                    cost += a
                } else {
                    cost += b
                }
            }
        }
        return cost
    }
    fun cleanCanvas(sy : Int, sx : Int, size : Int) {
        for (y in 0 until size) {
            for (x in 0 until size) {
                canvas[y + sy][x + sx] = '.'
            }
        }
    }
    var minCost = Int.MAX_VALUE
    for (line in 1 .. maxVal) {
        val d = makeDigud(line)
//        for (chars in d) {
//            println(chars.joinToString(""))
//        }
//        println()

        for (y in 0 until N) {
            if (y + line * 3 > N) continue
            for (x in 0 until M) {
                if (x + line * 3 > M) continue
                drawCanvas(y, x, d)

//                for (chars in canvas) {
//                    println(chars.joinToString(" "))
//                }
//                println()

                val cost = getCost()
                minCost = minCost.coerceAtMost(cost)
                cleanCanvas(y, x, line*3)
            }
        }
    }
    println(minCost)
}

/*
3 3
1 1
...
...
...

5 5
1 1
.....
.....
.....
.....
.....

10 9
1 1
.........
.........
.........
.........
.........
.........
.........
.........
.........
.........
 */