package acm.gold.acmicpc1107

import java.util.ArrayDeque
import java.util.StringTokenizer
import kotlin.math.abs

/* 리모컨 , 브루트 포스(?)
https://www.acmicpc.net/problem/1107
 */

fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    val broken = BooleanArray(10)
    if (M > 0) {
        val st = StringTokenizer(readln())
        repeat(M) {
            broken[st.nextToken().toInt()] = true
        }
    }

    val visit = HashMap<Int, Int>()
    val q = ArrayDeque<Channel>()
    var minCount = abs(N - 100)

    for (i in 0 .. 9) {
        if (!broken[i]) {
            q.add(Channel(1, i))
            visit[i] = 1
            minCount = minOf(minCount, abs(N - i) + 1)
        }
    }

//    q.add(Channel(0, 1))
//    visit[0] = 0
//    minCount = minOf(minCount, abs(N))


    while (q.isNotEmpty()) {
        val c = q.poll()
//        println(c)
        for (i in 0 .. 9) {
            if (!broken[i] && minCount > c.count + 1) {
                val nextCh = c.ch * 10 + i
                if (nextCh > N * 2) continue
                if (visit[nextCh] == null || (visit[nextCh] != null && visit[nextCh]!! > c.count + 1)) {
                    val curCount = abs(N - nextCh) + c.count + 1
                    minCount = minOf(minCount, curCount)

//                    println("${c} ${i} ${nextCh} ${c.count} ${curCount} ${minCount}")

                    visit[nextCh] = c.count + 1
                    q.add(Channel(c.count + 1, nextCh))
                }

            }
        }
    }
    println(minCount)
}
data class Channel (val count : Int, val ch : Int)

/*
35
3
6 7 8

889
9
0 2 3 4 5 6 7 8 9

1555
3
0 1 9

99933
2
3 9
73

 */