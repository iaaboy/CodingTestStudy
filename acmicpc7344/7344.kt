package acmicpc7344

import java.io.*
import java.util.*

/* 나무 막대, 그리디
https://www.acmicpc.net/problem/7344
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()

    val sb = StringBuilder()
    repeat(T) {
        val N = bf.readLine().toInt()
        val st = StringTokenizer(bf.readLine())
        val s = LinkedList<Stick>()
        repeat(N) {
            s.add(Stick(st.nextToken().toInt(), st.nextToken().toInt()))
        }

        s.sortWith(compareByDescending<Stick> { it.w }
            .thenByDescending { it.l })

        var count = 0
        while (s.isNotEmpty()) {
            var curL = s[0].l
            for (stick in s) {
                if (stick.l <= curL) {
                    curL = stick.l
                    stick.remove = true
                }
            }
            s.removeIf { it.remove }
            count++
        }

        sb.append("$count\n")
    }
    print(sb)
}

data class Stick(val l: Int, val w: Int, var remove: Boolean = false)

/*
1
5
10 2 9 1 4 10 3 9 2 2

1
3
1 2 2 3 4 5

SomeThingWrong : Stick(l=8, w=1) Stick(l=9, w=1) Stick(l=2, w=2) Stick(l=0, w=7) Stick(l=3, w=7) Stick(l=9, w=8) Stick(l=2, w=9)
1
7
8 1 9 1 2 2 0 7 3 7 9 8 2 9
 */
