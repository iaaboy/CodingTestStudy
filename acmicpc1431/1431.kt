package acmicpc1431

import java.io.BufferedReader
import java.io.InputStreamReader

/* 시리얼 번호
https://www.acmicpc.net/problem/1431
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    //A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
    //만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
    //만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
    val array = ArrayList<Pair<String, Int>>()
    repeat(bf.readLine().toInt()) {
        val str = bf.readLine()
        val sum = getSum(str.toCharArray())
        array.add(Pair(str, sum))
    }
    array.sortWith { a,b ->
        if (a.first.length == b.first.length) {
            if (a.second == b.second) {
                a.first.compareTo(b.first)
            } else {
                a.second - b.second
            }
        } else {
            a.first.length - b.first.length
        }
    }
    val sb = StringBuilder()
    for (pair in array) {
        sb.append("${pair.first}\n")
    }
    print(sb)
}

fun getSum(cArr: CharArray) : Int {
    var sum = 0
    for (ch in cArr) {
        if (ch >= '0' && ch <= '9') {
            sum += ch - '0'
        }
    }
    return sum
}
