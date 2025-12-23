package acmicpc1972

import java.io.BufferedReader
import java.io.InputStreamReader

/* 놀라운 문자열
https://www.acmicpc.net/problem/1972
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    while (true) {
        val inStr = bf.readLine()
        if ("*".contentEquals(inStr)) break
        val inChArray = inStr.toCharArray()
        var isPass = true
        for (diff in 1 until inChArray.size) { //간격
            val wordMap = HashSet<Pair<Char, Char>>()
            isPass = true
            for (i in 0 .. inChArray.size) {
                val j = i + diff
                if (j > inChArray.size - 1) break
                val p = Pair(inChArray[i], inChArray[j])
                if (wordMap.contains(p)) {
                    isPass = false
                }
                wordMap.add(p)
            }
            if (!isPass) {
                break
            }
        }
        if (isPass) {
            sb.append("$inStr is surprising.\n")
        } else {
            sb.append("$inStr is NOT surprising.\n")
        }
    }
    print(sb)
}