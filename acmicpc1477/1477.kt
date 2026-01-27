package acmicpc1477

import java.io.*
import java.util.*

/* 휴게소 세우기 , 이분탐색, 매개변수 탐색
https://www.acmicpc.net/problem/1477
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt() //현재 휴게소
    val M = st.nextToken().toInt() // 더 짓는 휴게소
    val L = st.nextToken().toInt() // 고속도로 길이

    st = StringTokenizer(bf.readLine())
    val arr = IntArray(N + 2)
    for (i in 1..N) {
        arr[i] = st.nextToken().toInt()
    }
    arr[0] = 0
    arr[N + 1] = L

    arr.sort()

//    println(arr.joinToString(" "))

    var left = 1
    var right = L
    var answer = 0
    while (left <= right) {
        val mid = (left + right) / 2
        if (canInstall(arr, mid, M)) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    println(answer)
}

fun canInstall(arr: IntArray, term: Int, M: Int): Boolean {
    var need = 0
    for (i in 1 until arr.size) {
        val gap = arr[i] - arr[i - 1]
        need += (gap - 1) / term
    }
    return need <= M
}
