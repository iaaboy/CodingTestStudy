package acm.gold.acmicpc18869

import java.util.StringTokenizer

/* 멀티버스 Ⅱ, 정렬 좌표압축
https://www.acmicpc.net/problem/18869
 */

fun main() {
    val st = StringTokenizer(readln())
    val M = st.nextToken().toInt() //max 100
    val N = st.nextToken().toInt() //
    val planets = Array(M) {
        val st = StringTokenizer(readln())
        IntArray(N) {
            st.nextToken().toInt()
        }
    }
    val codeMap = HashMap<List<Int>, Int>()

    for (p in planets) {
        val order = (0 until N).sortedBy { p[it] }

        val compressed = IntArray(N)
        var r = 0
        compressed[order[0]] = 0

        for (i in 1 until N) {
            if (p[order[i]] != p[order[i - 1]]) r++
            compressed[order[i]] = r
        }

        val key = compressed.toList()
        codeMap[key] = codeMap.getOrDefault(key, 0) + 1
    }
    var totalCount = 0

    fun getFactorial(n: Int): Int {
        var curNum = n
        var result = 0
        while (curNum > 0) {
            result += curNum--
        }
        return result
    }
    for (pairs in codeMap.values) {
        if (pairs > 1) {
            totalCount += getFactorial(pairs - 1)
        }
    }
//    println(codeMap)
    println(totalCount)

    //전체 count !(값 -1)
}

/*
1 3
1 3 2
 */