package acmicpc1343

import java.io.*

/* 폴리오미노 풀이
https://www.acmicpc.net/problem/1343
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val inChar = bf.readLine().replace("XXXX", "AAAA")
        .replace("XX", "BB")
    if (inChar.contains("X")) {
        println(-1)
    } else {
        println(inChar)
    }
}