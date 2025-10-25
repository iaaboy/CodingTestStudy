package acmicpc11292

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/* 키 큰 사람
https://www.acmicpc.net/problem/11292
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    while(true) {
        var st = StringTokenizer(bf.readLine())
        val N = st.nextToken().toInt()
        if (N == 0) break
        val arr = Array<Student>(N) {
            st = StringTokenizer(bf.readLine())
            Student(st.nextToken(), st.nextToken().toFloat())
        }
        arr.sortByDescending { it.height }
        val prev = arr.get(0).height
        for (student in arr) {
            if (student.height != prev) break
            sb.append(student.name).append(" ")
        }
        sb.append("\n")
    }
    print(sb)
}
private data class Student(val name: String, val height : Float)