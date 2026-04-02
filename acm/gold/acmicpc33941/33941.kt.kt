package acm.gold.acmicpc33941

/* 잔돈 싫어, dp
https://www.acmicpc.net/problem/33941
 */

fun main() {
    val N = readln().toInt()
    val array = ArrayList<Long>()

    repeat(N) {
        val num = readln().toLong()
        if (num in 500 ..< 20000) {
            array.add(num - 500)
        }
    }
    val n = array.size

    if (n == 0) {
        println(0)
        return
    }

    val dp = Array(n) {
        LongArray(500) { -1}
    }


    dp[0][(array[0] % 500L).toInt()] = array[0]

    for (i in 1 ..< n) {
        for (s in 0 ..< 500) {
            if (dp[i - 1][s] != -1L) {
                val nextVal = dp[i - 1][s] + array[i]
                val nextIdx = (nextVal % 500L).toInt()
                dp[i][nextIdx] = maxOf(dp[i][nextIdx], nextVal)
                val nextVal2 = dp[i - 1][s]
                val nextIdx2 = (nextVal2 % 500L).toInt()
                dp[i][nextIdx2] = maxOf(dp[i][nextIdx2], nextVal2)
            }
        }
    }
    if (dp[n-1][0] == -1L) dp[n-1][0] = 0
    println(dp[n-1][0])

//    for (longs in dp) {
//        for (lng in longs.indices) {
//            if (longs[lng] > 0) {
//                print("$lng: ${longs[lng]} ,")
//            }
//        }
//        println()
//    }
}