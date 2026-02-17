package acmicpc10330

import java.io.*
import java.util.*

/* 비트 문자열 재배열하기, 그리디
https://www.acmicpc.net/problem/10330
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    var countZero = 0
    st = StringTokenizer(bf.readLine())
    val numArray = IntArray(N) {
        val num = st.nextToken().toInt()
        if (num == 0) {
            countZero++
        }
        num
    }
    st = StringTokenizer(bf.readLine())

    val sequenceCode = IntArray(M) {
        st.nextToken().toInt()
    }

    fun swap(arr: IntArray, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

    fun checkSequence(start: Boolean): Int {
        val targetArray = IntArray(N)
        var initVal = when (start) {
            true -> 1
            false -> 0
        }
        var index = 0
        for (seq in sequenceCode) {
            repeat(seq) {
                targetArray[index++] = initVal
            }
            initVal = if (initVal == 1) {
                0
            } else {
                1
            }
        }

        val cZero = targetArray.count { it -> it == 0 }

        if (cZero != countZero) {
            return Int.MAX_VALUE
        }

//        println(targetArray.joinToString(" "))

        var countSwap = 0
        for (i in 0 until N) {
            if (numArray[i] != targetArray[i]) {
                var count = 1
                for (j in i + 1 until N) {
                    if (targetArray[j] == numArray[i]) {
                        swap(targetArray, j, i)
                        countSwap += count
                        break
                    }
                    count++
                }
            }
        }
        return countSwap
    }

    val result = minOf(checkSequence(true), checkSequence(false))
    println(result)
}

/*
2 2
0 1
1 1
 */