package acmicpc3711

import java.io.*
import java.util.*

/* 정육점
https://www.acmicpc.net/problem/2258
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val T = st.nextToken().toInt()
    val maxNumber = 1000000

//    println(primeNumbers)

    val sb = StringBuilder()
    repeat(T) {
        val G = bf.readLine().toInt()
        val arr = Array(G) { bf.readLine().toInt() }
        val hashSet = HashSet<Int>()
        for (p in 1..maxNumber) {
            var isComplete = true
            for (num in arr) {
                val remain = num % p
                if (hashSet.contains(remain)) {
                    hashSet.clear()
                    isComplete = false
                    break
                }
                hashSet.add(num % p)
            }
            hashSet.clear()
            if (isComplete) {
                sb.append(p).append("\n")
                break
            }

        }
    }
    print(sb)
}