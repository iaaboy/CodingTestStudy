package acm.gold.acmicpc1062

import java.util.StringTokenizer

/* 가르침, dfs, 비트 마스크
https://www.acmicpc.net/problem/1062
 */

fun main() {
    val st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val words = ArrayList<Int>()
    repeat(N) {
        val word = readln()
        var bit = 0

        for (i in 4 until word.length - 4) {
            bit = bit or (1 shl (word[i] - 'a'))
        }

        words.add(bit)
    }

    if (K < 5) {
        println(0)
        return
    } else if (K == 26) {
        println(N)
        return
    }

    var answer = 0
    fun dfs(idx: Int, count: Int, learned: Int) {
        if (count == K - 5) {
            var readable = 0
            for (w in words) {
                if ((w and learned) == w) {
                    readable++
                }
            }
            answer = maxOf(answer, readable)
            return
        }

        for (i in idx until 26) {
            if ((learned and (1 shl i)) != 0) continue
            dfs(i + 1, count + 1, learned or (1 shl i))
        }
    }

    val base = (1 shl ('a' - 'a')) or
            (1 shl ('n' - 'a')) or
            (1 shl ('t' - 'a')) or
            (1 shl ('i' - 'a')) or
            (1 shl ('c' - 'a'))

    dfs(0, 0, base)

    println(answer)
}