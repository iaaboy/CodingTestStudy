package acmicpc2109

import java.io.*
import java.util.*

/* 순회강연, 우선순위 큐, 그리디
https://solved.ac/contribute/2109
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val lecture = PriorityQueue<Lecture> {a,b ->
        b.date - a.date
    }
    var lastDay = 0
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        val pay = st.nextToken().toInt()
        val date = st.nextToken().toInt()
        lastDay = lastDay.coerceAtLeast(date)
        lecture.add(Lecture(pay, date))
    }

    val candidate = PriorityQueue<Lecture> {a,b ->
        b.pay - a.pay
    }

    var totalPay = 0
    for (today in lastDay downTo 1) {
        while (lecture.isNotEmpty() && lecture.peek().date >= today) {
            candidate.add(lecture.poll())
        }
        if (candidate.isNotEmpty()) {
//            println("$today ${candidate.peek()}")
            totalPay += candidate.poll().pay
        }
    }
    println(totalPay)
}

private data class Lecture(val pay: Int, val date: Int, var isUsed : Boolean = false)
