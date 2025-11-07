package acmicpc15965

import java.io.BufferedReader
import java.io.InputStreamReader

/* K번째 소수
https://www.acmicpc.net/problem/15965
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val K = bf.readLine().toInt()
    val N = 7368787
    val isPrime = BooleanArray(N + 1)
    isPrime[0] = true
    isPrime[1] = true
    var count = 0
    for (i in 1 ..  N) {
        if (isPrime[i]) continue
        count++
        if (count == K) {
            println(i)
            return
        }
        for (j in i + i .. N step i) {
            isPrime[j] = true
        }
    }

//    println("\n $count")
//
//    count = 0
//    for ((index, bool) in isPrime.withIndex()) {
//        if (index == 1000) break
//        if(!bool) {
//            print("$index ")
//            count++
//        }
//    }
//    println("\n $count")
}