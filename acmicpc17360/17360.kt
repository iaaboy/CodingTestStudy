package acmicpc17360

import java.io.*
import java.util.*

private const val MOD: Long = 1_000_000_007L

private fun powMod(a: Long, e: Long): Long {
    var base = a % MOD
    var exp = e
    var res = 1L
    while (exp > 0) {
        if ((exp and 1L) == 1L) res = (res * base) % MOD
        base = (base * base) % MOD
        exp = exp shr 1
    }
    return res
}

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toLong()
    val M = st.nextToken().toLong()
    val K = st.nextToken().toLong()

    var ans = when {
        K > N -> {
            powMod(M, N)
        }

        K == 1L -> {
            powMod(M, N)
        }

        K == N -> {
            powMod(M, (N + 1) / 2)
        }

        else -> { // 1 < K < N
            when {
                K == 2L -> {
                    M % MOD
                }
                (K and 1L) == 1L -> powMod(M, 2)    // k>=3 홀수: 2-주기
                else -> M % MOD
            }
        }
    }
    ans %= MOD
    println(ans)
}