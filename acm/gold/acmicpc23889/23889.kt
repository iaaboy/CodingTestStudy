package acm.gold.acmicpc23889

import java.util.*

/* 돌 굴러가유, 그리디 누적합
https://www.acmicpc.net/problem/23889
 */

fun main() {
    var st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val sandCastles = IntArray(N + 1)
    val sums = IntArray(N + 1)
    for (i in 1 .. N) {
        sandCastles[i] = st.nextToken().toInt()
    }
    st = StringTokenizer(readln())
    val stones = BooleanArray(N + 1)
    repeat(K){
        stones[st.nextToken().toInt()] = true
    }
    var sum = 0
    for (i in N downTo 0) {
        if (!stones[i]) {
            sum+=sandCastles[i]
        } else {
            sum+=sandCastles[i]
            sums[i] = sum
            sum = 0
        }
    }

//    println(sandCastles.joinToString(" "))
//    println(sums.joinToString(" "))

    val sumIndex = IntArray(N + 1) {it}.sortedByDescending { sums[it] }.subList(0, M).sorted()
//    println(sumIndex.joinToString(" "))

    val sb = StringBuilder()
    for (i in sumIndex) {
        sb.append("$i\n")
    }
    print(sb)
}

/*

10 2 3
1 4 7 1 2 4 3 6 10 100
1 5 8
1
8

10 2 3
1 4 7 1 2 4 3 6 1 1
1 5 8
 */
