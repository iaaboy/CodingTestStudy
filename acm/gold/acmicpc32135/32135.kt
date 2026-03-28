package acm.gold.acmicpc32135

/* 합성방진, 해구성하기
https://www.acmicpc.net/problem/32135
 */

fun main() {
    val N = readln().toInt()

    if (N < 6) {
        println(-1)
        return
    }

    val array = arrayListOf(3, 6)
    for (i in 2 .. N step 2) {
        if (i == 6 || i == 4) continue
        array.add(i)
    }
    array.add(4)
    array.add(5)
    for (i in 1 .. N step 2) {
        if (i == 3 || i == 5) continue
        array.add(i)
    }

    val sb = StringBuilder()
    for (start in 0 ..< N) {
        for (i in 0 ..< N) {
            val index = (start + i) % N
            sb.append("${array[index]} ")
        }
        sb.append("\n")
    }
    println(sb)
}