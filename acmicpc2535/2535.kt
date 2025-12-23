package acmicpc2535

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/* 아시아 정보올림피아드 풀이
https://www.acmicpc.net/problem/2535
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val studentList = ArrayList<Student>()
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        studentList.add(Student(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }
    studentList.sortWith { a,b ->
        b.score - a.score
    }
    val countryExclude = when {
        (studentList[0].country == studentList[1].country) -> {
            studentList[0].country
        }
        else -> -1
    }
    val sb = StringBuilder()
    sb.append("${studentList[0].country} ${studentList[0].id}\n")
    sb.append("${studentList[1].country} ${studentList[1].id}\n")
    for (i in 2 until  studentList.size) {
        if (studentList[i].country != countryExclude) {
            sb.append("${studentList[i].country} ${studentList[i].id}\n")
            break
        }
    }
    print(sb)
}
data class Student (val country : Int, val id : Int, val score: Int)