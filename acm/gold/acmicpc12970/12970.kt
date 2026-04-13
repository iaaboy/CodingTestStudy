package acm.gold.acmicpc12970

import java.util.StringTokenizer

/* AB, 그리디, 해구성하기.
https://www.acmicpc.net/problem/12970
 */

fun main() {
    val st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val array = CharArray(N)
    for (i in 0..<N) {
        if (i < N / 2) {
            array[i] = 'B'
        } else {
            array[i] = 'A'
        }
    }

    val maxCount = (N / 2) * ((N + 1) / 2)
    if (K > maxCount) {
        println(-1)
        return
    }

    repeat(K) {
        //b 다음 맨 왼쪽 A
        for (i in 1..<N) {
            if (array[i - 1] == 'B' && array[i] == 'A') {
                array[i - 1] = 'A'
                array[i] = 'B'
                break
            }
        }
    }

//    println("$maxCount ${array.joinToString(" ")}")
    println(String(array))
}
