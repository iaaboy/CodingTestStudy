package acm.gold.acmicpc15998

import java.util.StringTokenizer

/* 카카오머니, 정수론. gcd
https://www.acmicpc.net/problem/15998
 */

fun main() {
    val N = readln().toInt()
    var currentRemained = 0L

    var isStable = true

    fun gcd(a: Long, b: Long): Long {
        var x = a
        var y = b
        while (y != 0L) {
            val t = x % y
            x = y
            y = t
        }
        return kotlin.math.abs(x)
    }

    var result = -1L
    var minB = Long.MAX_VALUE

    repeat(N) {
        val st = StringTokenizer(readln())
        val withdrawal = st.nextToken().toLong()
        val nextRemained = st.nextToken().toLong()

        if (currentRemained + withdrawal < 0 ) {
            val exchange = nextRemained - currentRemained - withdrawal

            if (exchange <= 0L) {
                isStable = false
            } else {
                if (result == -1L) {
                    result = exchange
                } else {
                    val r = gcd(exchange, result)
                    if (r == 1L) {
                        isStable = false
                    } else {
                        result = r
                    }
                }

                if (nextRemained > 0) {
                    minB = minOf(minB, nextRemained)
                }
            }

        } else {
            if (currentRemained + withdrawal != nextRemained) {
                isStable = false
            }
        }

        currentRemained = nextRemained
    }

    if (result != -1L && result <= minB) {
        isStable = false
    }

    if (!isStable) {
        println(-1)
    } else {
        if (result == -1L) result = 1
        println(result)
    }
}