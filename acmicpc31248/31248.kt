package acmicpc31248

import java.io.*

/* 3+1 하노이 탑 , 재귀
https://www.acmicpc.net/problem/31248
 */

fun main() {
    val sb: StringBuilder = StringBuilder()
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()

    var M = 0
    fun move(from: Char, to: Char) {
        sb.append(from).append(' ').append(to).append('\n')
        M++
    }

    fun hanoi(N: Int, from: Char, to: Char, rest: Char) {
        if (N == 1) {
            move(from, to)
            return
        }

        hanoi(N - 1, from, rest, to)
        hanoi(1, from, to, rest)
        hanoi(N - 1, rest, to, from)
    }

    fun dHanoi(N: Int, from: Char, to: Char, rest1: Char, rest2: Char) {
        if (N == 1) {
            move(from, to)
            return
        } else if (N == 2) {
            move(from, rest2)
            move(from, to)
            move(rest2, to)
            return
        }

        hanoi(N - 2, from, rest1, rest2) // 1. (N - 2)개를 D가 아닌 기둥으로 옮기기
        move(from, rest2) // 2. 두 번째로 큰 원판을 D가 아닌 비어있는 기둥으로 옮기기
        move(from, to) // 3. 가장 큰 원판을 D로 옮기기
        move(rest2, to) // 4. 두 번째로 큰 원판을 D로 옮기기
        dHanoi(N - 2, rest1, to, from, rest2)
    }

    dHanoi(N, 'A', 'D', 'B', 'C')
    println(M)
    println(sb)
}
