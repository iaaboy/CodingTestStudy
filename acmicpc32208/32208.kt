package acmicpc32208

import java.io.*
import java.util.*

/* Knight Cruising, 애드 혹 불변량 찾기
https://www.acmicpc.net/problem/32208
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val st = StringTokenizer(bf.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        when ((a + b + c) % 2 == 0) {
            true -> sb.append("YES\n")
            false -> sb.append("NO\n")
        }
    }
    print(sb)
}
