package acmicpc29792

import java.io.*
import java.util.*
import kotlin.math.ceil
import kotlin.math.max

/* 규칙적인 보스돌이
https://www.acmicpc.net/problem/29792
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st1 = StringTokenizer(bf.readLine())
    val N = st1.nextToken().toInt() // 캐릭터 수
    val M = st1.nextToken().toInt() // 선택 가능한 캐릭터 수
    val K = st1.nextToken().toInt() // 보스 수

    val damage = LongArray(N) { bf.readLine().trim().toLong() }

    val bossHP = DoubleArray(K)
    val bossReward = IntArray(K)
    repeat(K) {
        val st = StringTokenizer(bf.readLine())
        bossHP[it] = st.nextToken().toDouble()
        bossReward[it] = st.nextToken().toInt()
    }

    val maxSecond = 900 // 15분 = 900초
    val reward = IntArray(N)

    for (i in 0 until N) {
        val dp = IntArray(maxSecond + 1)
        for (j in 0 until K) {
            val timeNeeded = ceil(bossHP[j] / damage[i]).toInt()
            val reward = bossReward[j]
            if (timeNeeded > maxSecond) continue
            for (t in maxSecond downTo timeNeeded) {
                dp[t] = max(dp[t], dp[t - timeNeeded] + reward)
            }
        }
        reward[i] = dp.maxOrNull()!!
    }

    reward.sortDescending()
    val answer = reward.take(M).sum()

    println(answer)
}

/*
3 2 3
1
2
3
900.2 30
1800.3 40
2699.7 50
 */