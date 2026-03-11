package acmicpc12904

import java.io.*

/* A와 B, 그리디, 문자열 구현
https://www.acmicpc.net/problem/12904
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val S = bf.readLine()
    val T = bf.readLine()

    var hasMatch = false
    fun dfs(curWord : String) {
//        println(curWord)
        if (hasMatch) return
        if (curWord.length == S.length) {
            if (curWord.contentEquals(S)) {
                hasMatch = true
            }
            return
        }
        if (curWord.length < S.length) return

        //문자열의 뒤에 A를 추가한다.
        // -> 문자열 앞을 지운다.
        if (curWord.last() == 'A') {
            dfs(curWord.substring(0, curWord.length - 1))
        }

        //문자열을 뒤집고 뒤에 B를 추가한다.
        if (curWord.last() == 'B') {
            dfs(curWord.substring(0, curWord.length - 1).reversed())
        }

    }
    dfs(T)
    if (hasMatch) {
        println(1)
    } else {
        println(0)
    }
}

