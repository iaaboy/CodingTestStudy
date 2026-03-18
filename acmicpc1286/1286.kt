package acmicpc1286

import java.io.*
import java.util.StringTokenizer

/* 부분 직사각형, 누적합.
https://www.acmicpc.net/problem/1286
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val map = Array(N * 2) { CharArray(M * 2) }

    val origin = Array(N) { br.readLine().toCharArray() }

    for (i in 0 until 2) {
        for (j in 0 until 2) {
            for (y in 0 until N) {
                for (x in 0 until M) {
                    map[i * N + y][j * M + x] = origin[y][x]
                }
            }
        }
    }

    val prefix = Array(26) { Array(N * 2 + 1) { IntArray(M * 2 + 1) } }

    for (c in 0 until 26) {
        for (y in 1..N * 2) {
            for (x in 1..M * 2) {
                prefix[c][y][x] =
                    prefix[c][y - 1][x] +
                            prefix[c][y][x - 1] -
                            prefix[c][y - 1][x - 1] +
                            if (map[y - 1][x - 1] - 'A' == c) 1 else 0
            }
        }
    }

    val ans = LongArray(26)

    for (y1 in 1..N * 2) {
        for (x1 in 1..M * 2) {
            for (y2 in y1..N * 2) {
                for (x2 in x1..M * 2) {

                    for (c in 0 until 26) {
                        val cnt = prefix[c][y2][x2] - prefix[c][y1 - 1][x2] - prefix[c][y2][x1 - 1] + prefix[c][y1 - 1][x1 - 1]
                        ans[c] += cnt
                    }

                }
            }
        }
    }

    println(ans.joinToString("\n"))
}
