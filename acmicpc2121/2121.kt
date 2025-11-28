package acmicpc2121

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val pSet = HashSet<Ptr>()

    val N = bf.readLine().toInt()
    var st = StringTokenizer(bf.readLine())
    val A = st.nextToken().toInt()
    val B = st.nextToken().toInt()
    repeat(N) {
        st = StringTokenizer(bf.readLine())
        pSet.add(Ptr(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    var count = 0
    for (point in pSet) {
        if (pSet.contains(Ptr(point.y + A, point.x))) {
            if (pSet.contains(Ptr(point.y, point.x + B))) {
                if (pSet.contains(Ptr(point.y + A, point.x + B))) {
                    count++
                }
            }
        }
//        println("$point $count")
    }
    println(count)
}
data class Ptr(val y : Int, val x : Int)