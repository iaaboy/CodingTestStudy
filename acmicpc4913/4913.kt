package acmicpc4913

import java.io.*
import java.util.*

/* 페르마의 크리스마스 정리
https://www.acmicpc.net/problem/4913
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = 1000000
    val notPrime = BooleanArray(N + 1)
    notPrime[0] = true
    notPrime[1] = true
    for (i in 2..N / 2) {
        if (!notPrime[i]) {
            var j = i * 2
            while (j <= N) {
                if (!notPrime[i]) notPrime[j] = true
                j += i
            }
        }
    }
    val primeNumbers = ArrayList<Int>()
    for ((index, bool) in notPrime.withIndex()) {
        if (!bool) {
            primeNumbers.add(index)
        }
    }

    val prefixSum = IntArray(N + 1)
    var sum = 1
    prefixSum[2] = 1
    for (num in 3..N) {
        if (!notPrime[num] && num % 4 == 1)
            sum++
        prefixSum[num] = sum
    }

    while (true) {
        val st = StringTokenizer(bf.readLine())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        if (s == -1 && e == -1) {
            break
        }
        val calcS = if (s < 0) {
            0
        } else {
            s
        }
        val calcE = if (e < 0) {
            0
        } else {
            e
        }

        val primeCount = countInRange(primeNumbers, calcS, calcE)
        val sqPrimeCount = if (calcS == 0) {
            prefixSum[calcE]
        } else {
            prefixSum[calcE] - prefixSum[calcS - 1]
        }
        print("$s $e $primeCount $sqPrimeCount\n")
    }
//    print(sb)
}

/*
중복 원소가 없을 때에만 사용 가능
 */
fun countInRange(list: List<Int>, S: Int, E: Int): Int {
    // S 이상인 첫 위치
    val left = list.binarySearch(S).let {
        if (it >= 0) it else -it - 1
    }
    // E 초과인 첫 위치
    val right = list.binarySearch(E).let {
        if (it >= 0) it + 1 else -it - 1
    }
    return (right - left).coerceAtLeast(0)
}
