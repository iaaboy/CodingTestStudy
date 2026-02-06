package acmicpc3933

import java.io.*

/* 라그랑주의 네 제곱수 정리,브룻포스
https://www.acmicpc.net/problem/3933
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val MAX = 32768
    val squares = ArrayList<Int>()
    squares.add(0)
    var i = 1
    while (i * i < MAX) {
        squares.add(i * i)
        i++
    }
//    println(squares)

    val count = IntArray(MAX)
    val size = squares.size
    for (a in 0 until size) {
        val sa = squares[a]
        if (sa >= MAX) break

        for (b in a until size) {
            val sb = sa + squares[b]
            if (sb >= MAX) break

            for (c in b until size) {
                val sc = sb + squares[c]
                if (sc >= MAX) break

                for (d in c until size) {
                    val sum = sc + squares[d]
                    if (sum >= MAX) break
                    count[sum]++
                }
            }
        }
    }

    var num = bf.readLine().toInt()
    val sb = StringBuilder()
    while (num != 0) {
        sb.append(count[num]).append("\n")
        num = bf.readLine().toInt()
    }

    print(sb)
}

