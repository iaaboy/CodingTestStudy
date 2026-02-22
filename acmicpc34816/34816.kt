package acmicpc34816

import java.io.*
import java.util.*

/* 짝수 길이의 짝수 합, 애드혹
https://www.acmicpc.net/problem/34816
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val Q = st.nextToken().toInt()

    val s = StringBuilder(br.readLine().trim())
    val sb = StringBuilder()

    repeat(Q) {
        val line = StringTokenizer(br.readLine())
        val type = line.nextToken().toInt()

        if (type == 1) {
            val i = line.nextToken().toInt() - 1
            s[i] = if (s[i] == '0') '1' else '0'
        } else {
            val x = line.nextToken().toInt() - 1
            val y = line.nextToken().toInt() - 1
            val len = y - x + 1

            if (len >= 4) {
                sb.append("YES\n")
            } else if (len == 1) {
                sb.append("NO\n")
            } else if (len == 2) {
                val sum = (s[x] - '0') + (s[y] - '0')
                if (sum % 2 == 0) sb.append("YES\n")
                else sb.append("NO\n")
            } else { // len == 3
                var found = false
                for (l in x..y) {
                    for (r in l..y) {
                        val subLen = r - l + 1
                        if (subLen % 2 == 0) {
                            var sum = 0
                            for (k in l..r) sum += s[k] - '0'
                            if (sum % 2 == 0) {
                                found = true
                            }
                        }
                    }
                }
                if (found) sb.append("YES\n")
                else sb.append("NO\n")
            }
        }
    }

    print(sb)
}
