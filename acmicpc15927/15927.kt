package acmicpc15927

import java.io.*

/* 회문은 회문아니야!!
https://www.acmicpc.net/problem/15927
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val inputStr = bf.readLine()
    val isPalinedrome = checkPalindrome(inputStr)
    if (isPalinedrome) {
        if (inputStr.chars().allMatch {
                it == inputStr.get(0).code
            }) {
            println(-1)
        } else {
            println(inputStr.length - 1)
        }
    } else {
        println(inputStr.length)
    }
}

fun checkPalindrome(inputStr: String): Boolean {
    for (i in 0..inputStr.length / 2) {
        if (inputStr.get(i) != inputStr.get(inputStr.length - 1 - i)) {
            return false
        }
    }
    return true
}

/*
심플 버전
fun main() {
    val s = readLine()!!

    when {
        s != s.reversed() -> println(s.length)
        s.all { it == s[0] } -> println(-1)
        else -> println(s.length - 1)
    }
}
 */