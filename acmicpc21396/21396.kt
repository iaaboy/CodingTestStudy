package acmicpc21396

import java.io.*
import java.util.*

/* 이진수 더하기
https://www.acmicpc.net/problem/21396
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        var st = StringTokenizer(bf.readLine())
        val n = st.nextToken().toInt()
        val x = st.nextToken().toLong()
        var count = 0L
        st = StringTokenizer(bf.readLine())
        val numMap = HashMap<Long, Long>()
        repeat(n) {
            val v = st.nextToken().toLong()
            val need = v xor x
            numMap[need]?.let {
                count+= it
            }
            numMap[v] = (numMap[v] ?: 0L) + 1L
        }
        count
        sb.append("$count\n")
    }
    print(sb)
}

