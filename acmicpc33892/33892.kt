package acmicpc33892

import java.io.BufferedReader
import java.io.InputStreamReader

/* 2025 만들기, 해 구성하기... 어렵다ㅠ.ㅠ
https://www.acmicpc.net/problem/33892
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().trim().toInt()
    val sb = StringBuilder()

    if (n < 7) {
        println("NO")
        return
    }

    sb.append("YES\n")

    sb.append("7 * 6\n")
    sb.append("42 * 2\n")
    sb.append("84 - 3\n")
    sb.append("81 * 5\n")

    if (n > 10) {
        sb.append("11 - 10\n")
        sb.append("9 - 8\n")
        sb.append("1 - 1\n")

        for (i in 12..n) {
            sb.append("$i * 0\n")
        }

        sb.append("1 + 0\n")
    } else if (n >= 9) {
        sb.append("$n - ${n - 1}\n")
        sb.append("1 * 1\n")
        n -= 2
    }

    if (n == 8) {
        sb.append("8 - 4\n")
    }

    sb.append("4 + 1\n")
    sb.append("405 * 5\n")

    print(sb.toString())
}
