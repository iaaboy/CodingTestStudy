package acmicpc25542

import java.io.*
import java.util.*

/*
약속 장소 풀이, 구현 문자열
https://www.acmicpc.net/problem/25542
 */

var L = 0
var N = 0
lateinit var words: Array<String>
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    N = st.nextToken().toInt()
    L = st.nextToken().toInt()
    words = Array(N) {
        bf.readLine()
    }

    val base = words[0].toCharArray()

    // 0글자 변경 후보도 먼저 체크
    if (ok(base)) {
        println(String(base))
        return
    }

    // 1글자 변경 후보들 체크
    for (i in 0 until L) {
        val original = base[i]
        for (c in 'A'..'Z') {
            base[i] = c
            if (ok(base)) {
                println(String(base))
                return
            }
        }
        base[i] = original
    }

    println("CALL FRIEND")

}

fun ok(candidate: CharArray): Boolean {
    for (w in words) {
        var diff = 0
        for (j in 0 until L) {
            if (candidate[j] != w[j]) {
                diff++
                if (diff > 1) break
            }
        }
        if (diff > 1) return false
    }
    return true
}

