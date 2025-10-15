package acmicpc1153

import java.io.*
import java.util.*

/* 네 개의 소수
https://www.acmicpc.net/problem/1153
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val erastos = BooleanArray(N + 1)
    erastos[0] = true
    erastos[1] = true
    for (i in 2..N / 2) {
        if (erastos[i])
            continue
        var j = i * 2
        while (j <= N) {
            if (!erastos[j]) {
                erastos[j] = true
            }
            j += i
        }
    }

    val primeNumbers = ArrayList<Int>()
    for ((index, bool) in erastos.withIndex()) {
        if (!bool)
            primeNumbers.add(index)
    }

//    println(primeNumbers)

    for (i1 in primeNumbers) {
        for (i2 in primeNumbers) {
            if (i1 + i2 > N) break
            for (i3 in primeNumbers) {
                if (i1 + i2 + i3 > N) break
                for (i4 in primeNumbers) {
                    val sum = i1 + i2 + i3 + i4
                    if (sum > N) break
                    if (sum == N) {
                        println("$i1 $i2 $i3 $i4")
                        return
                    }
                }
            }
        }
    }
    println(-1)
}
