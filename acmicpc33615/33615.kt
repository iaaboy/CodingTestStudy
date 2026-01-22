package acmicpc33615

import java.io.*

/* 1과 5 , 정수론 애드혹
https://www.acmicpc.net/problem/33615
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val numStr = bf.readLine()
        var digitSum = 0
        for (ch in numStr) {
            digitSum += ch -'0'
        }

        if (numStr.last() == '5') {
            sb.append("0 5\n")
            return@repeat
        }

        val digitMod = digitSum % 3

        if (digitMod == 2 && !numStr.contains('5')) {
            if (numStr.length % 2 == 0) {
                sb.append("0 11\n")
            } else {
                sb.append("1 11\n")
            }
            return@repeat
        }


        when (digitMod) {
            0 -> {sb.append("0 3\n")}
            1 -> {sb.append("${checkComposite('1', numStr)} 3\n")}
            2 -> {sb.append("${checkComposite('5', numStr)} 3\n")}
        }
    }
    print(sb)
}

fun checkComposite(findingDigit : Char, numStr : String) : Int {
    for ((index, ch) in numStr.withIndex()) {
        if (findingDigit == ch) return index + 1
    }
    return 0
}
