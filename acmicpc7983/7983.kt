package acmicpc7983

import java.io.*
import java.util.*

/* 내일 할거야, 정렬, 그리디
https://www.acmicpc.net/problem/7983
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()
    val pq = PriorityQueue<Work>{a,b ->
        b.end - a.end
    }
    var lastPoint = 0
    repeat(n) {
        val st = StringTokenizer(bf.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        pq.add(Work(end - start, end))
        lastPoint = lastPoint.coerceAtLeast(end)
    }

    var me = pq.poll()
    while (pq.isNotEmpty()) {
        val you = pq.poll()
        if(you.end > me.start) {
            //합친다.

            val youStart = you.start - (me.end - me.start)
            val myStart = me.start - (you.end - you.start)

            if (youStart > myStart) {
                me.start = youStart
                me.end = you.end
            } else {
                me.start = myStart
                me.end = me.end
            }
        } else {
            me = you
        }
//        println(me)
    }
    println(me.start)
}
private data class Work(var start : Int, var end : Int)
