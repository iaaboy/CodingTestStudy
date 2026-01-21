package acmicpc1092

import java.io.*
import java.util.*

/* 배, 정렬 그리디
https://www.acmicpc.net/problem/1092
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    var st = StringTokenizer(bf.readLine())
    val ships = IntArray(N) {st.nextToken().toInt()}
    val count = IntArray(N)
    val M = bf.readLine().toInt()
    st = StringTokenizer(bf.readLine())
    val containers = IntArray(M) {st.nextToken().toInt()}
    ships.sort()
    containers.sortDescending()

//    println(ships.contentToString())
//    println(containers.contentToString())

    for (c in 0 until M) {
        var candidate = -1
        for (s in 0 until N) {
            if (ships[s] >= containers[c]) {
                if (candidate == -1) {
                    candidate = s
                } else {
                    if (count[candidate] > count[s]) {
                        candidate = s
                    }
                }
            }
        }
        if (candidate != -1) count[candidate]++
    }

    if (count.sum() != M) {
        println(-1)
    } else {
        println(count.max())
    }
}