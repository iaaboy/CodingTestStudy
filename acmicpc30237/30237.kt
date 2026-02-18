package acmicpc30237

import java.io.*
import java.util.*

/* 합집합, 비트 마스킹, 브루트 포스
https://www.acmicpc.net/problem/30237
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val N = bf.readLine().toInt()

        val sets = LongArray(N)
        var union = 0L

        repeat(N) { i ->
            val st = StringTokenizer(bf.readLine())
            val k = st.nextToken().toInt()

            var mask = 0L
            repeat(k) {
                val x = st.nextToken().toInt()
                mask = mask or (1L shl x)
            }

            sets[i] = mask
            union = union or mask
        }

        var answer = 0

        for (x in 0..50) {
            if ((union and (1L shl x)) != 0L) {

                var cur = 0L

                for (i in 0 until N) {
                    if ((sets[i] and (1L shl x)) == 0L) {
                        cur = cur or sets[i]
                    }
                }

                answer = maxOf(answer, java.lang.Long.bitCount(cur))
            }
        }

        sb.append(answer).append("\n")
    }
    print(sb)
}
