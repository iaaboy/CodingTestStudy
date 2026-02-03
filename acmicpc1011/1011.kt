package acmicpc1011

import java.io.*
import java.util.*

/* Fly me to the Alpha Centauri, 수학
https://www.acmicpc.net/problem/1011
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    (1 .. T).forEach { _ ->
        val st = StringTokenizer(bf.readLine())
        val from = st.nextToken().toLong()
        val to = st.nextToken().toLong()

        var lightYear = 0L
        val distanceLeft = to - from
        var movedDistance = 0L
        var count = 0L

        while (true) {
            lightYear += 1
            movedDistance += lightYear * 2
            count += 2

            if (movedDistance - lightYear >= distanceLeft) {
                sb.append(count - 1).append("\n")
                break
            }
            else if (movedDistance >= distanceLeft) {
                sb.append(count).append("\n")
                break
            }
        }
    }
    print(sb)
}
