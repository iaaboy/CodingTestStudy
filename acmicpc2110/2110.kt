package acmicpc2110

import java.io.*
import java.util.*

/* 공유기 설치, 이분 탐색 .. 매개변수 탐색
https://www.acmicpc.net/problem/2110
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val C = st.nextToken().toInt()
    val arr = IntArray(N) {
        bf.readLine().toInt()
    }
    arr.sort()
    var left = 1
    var right = arr[N - 1] - arr[0]
    var answer = 0
    while (left <= right) {
        val mid = (left + right) / 2
        if (canInstall(arr, mid, C)) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(answer)
}

fun canInstall(arr: IntArray, distance: Int, count: Int): Boolean {
    var prev = arr[0]
    var left = count - 1
    for (i in 1..<arr.size) {
        if (arr[i] - prev >= distance) {
            prev = arr[i]
            left--
            if (left == 0) return true
        }
    }
    return false
}
