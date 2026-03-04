package acmicpc34242

import java.io.*

/* 힝스티비, 구현
https://www.acmicpc.net/problem/34242
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val inStr = bf.readLine().toCharArray()
    val baseScore = IntArray(inStr.size)
    fun getScore (i : Int) : Int {
        var score = 0
        if (i == 0 || i == inStr.size - 1) return 0
        if (inStr[i] == '^') {
            if (inStr[i - 1] == '-' && inStr[i + 1] == '-') {
                score = -1
            } else if (inStr[i - 1] == '+' && inStr[i + 1] == '+') {
                score = 1
            }
        }
        return score
    }
    for (i in 1 until inStr.size - 1) {
        baseScore[i] = getScore(i)
    }
    fun getScoreIfAbsent(i: Int): Int {
        var subCount = if (i > 0) { baseScore[i - 1] } else {0}
        subCount += baseScore[i]
        subCount += if (i < inStr.size - 1) { baseScore[i + 1] } else {0}
        return subCount
    }

    fun getLeft(i: Int): Int {
        var score = 0
        if (i - 1 < 0 || i + 2 >= inStr.size) return 0
        if (inStr[i] == '^') {
            if (inStr[i - 1] == '-' && inStr[i + 2] == '-') {
                score = -1
            } else if (inStr[i - 1] == '+' && inStr[i + 2] == '+') {
                score = 1
            }
        }
        return score
    }
    fun getRight(i: Int): Int {
        var score = 0
        if (i - 2 < 0 || i + 1 >= inStr.size) return 0
        if (inStr[i] == '^') {
            if (inStr[i - 2] == '-' && inStr[i + 1] == '-') {
                score = -1
            } else if (inStr[i - 2] == '+' && inStr[i + 1] == '+') {
                score = 1
            }
        }
        return score
    }
    val sum = baseScore.sum()
    var sumMax = sum
    for (i in 0 until inStr.size) {
        val offset = getScoreIfAbsent(i)
        val left = getLeft(i - 1)
        val right = getRight(i + 1)
        val partialSum = - offset + left + right
        sumMax = maxOf(sumMax, sum + partialSum)
//        println("$i o:$offset l:$left r:$right  sumMax$sumMax")
    }

//    println(baseScore.joinToString(" "))
    println(sumMax)
}

// +-^-+^++
// -^-+^+++^+