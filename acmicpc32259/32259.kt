package acmicpc32259

import java.io.*

/* 가짜 금화 찾기, 삼분탐색
https://www.acmicpc.net/problem/32259
 */

val bf = BufferedReader(InputStreamReader(System.`in`))

fun ask(a: List<Int>, b: List<Int>): Char {
    print("? ")
    for (x in a) print("$x ")
    print("0 ")
    for (x in b) print("$x ")
    println("0")
    System.out.flush()

    return bf.readLine()[0]
}

fun main() {
    val N = bf.readLine().toInt()

    var cand = (1..N).toMutableList()

    repeat(5) {

        if (cand.size == 1) {
            println("! ${cand[0]}")
            System.out.flush()
            return
        }

        if (cand.size == 2) {
            val a = listOf(cand[0])
            val b = listOf(cand[1])

            val r = ask(a, b)

            val ans = if (r == '<') cand[0] else cand[1]

            println("! $ans")
            System.out.flush()
            return
        }

        val k = cand.size / 3

        val A = cand.subList(0, k)
        val B = cand.subList(k, 2 * k)
        val C = cand.subList(2 * k, cand.size)

        val r = ask(A, B)

        cand = when (r) {
            '<' -> A.toMutableList()
            '>' -> B.toMutableList()
            else -> C.toMutableList()
        }
    }

    println("! ${cand[0]}")
    System.out.flush()
}
