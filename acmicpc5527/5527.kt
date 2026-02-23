package acmicpc5527

import java.io.*
import java.util.StringTokenizer

/* 전구 장식, 애드혹
https://www.acmicpc.net/problem/5527
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val number = BooleanArray(N) {
        st.nextToken().toInt() == 1
    }

    var countLeftFromHere = 1
    val flipCandidate = ArrayList<Int>()
    for (i in 1 until N) {
        if (number[i] != number[i - 1]) {
            countLeftFromHere++
        } else {
//            println("$i $countLeftFromHere")
            flipCandidate.add(countLeftFromHere)
            countLeftFromHere = 1
        }
    }
    flipCandidate.add(countLeftFromHere)

    var fromIndex = 0
    var maxCount = 0
    for (i in flipCandidate.indices) {
        val start = fromIndex
        val end = fromIndex + flipCandidate[i] - 1

        var totalCount = flipCandidate[i]
        if (i - 1 >= 0 && number[start - 1] == number[start]) {
            totalCount += flipCandidate[i - 1]
        }

        if (i + 1 < flipCandidate.size && number[end] == number[end + 1]) {
            totalCount += flipCandidate[i + 1]
        }

        maxCount = maxOf(maxCount, totalCount)
//        println(totalCount)

        fromIndex = end + 1
    }
    println(maxCount)
}
