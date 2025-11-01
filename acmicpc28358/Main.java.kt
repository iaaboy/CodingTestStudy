package acmicpc28358

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/* 생일 맞추기
https://www.acmicpc.net/problem/28358
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    repeat(bf.readLine().toInt()) {
        val st = StringTokenizer(bf.readLine())
        val isAvail = BooleanArray(10)
        for (i in 0 until 10) {
            isAvail[i] = st.nextToken().toInt() == 0
        }

        //1 - 9
        var day29 = 0
        for (d in 1..9) {
            if (isAvail[d]) day29++
        }
        for (first in 1..2) {
            if (!isAvail[first]) continue
            for (second in 0..9) {
                if (isAvail[second]) day29++
            }
        }
        //30, 31
        val day30 = if (isAvail[3] && isAvail[0]) 1 else 0
        val day31 = if (isAvail[3] && isAvail[1]) 1 else 0

        //30Month 4, 6, 9, 11
        var month30 = 0
        for (i in listOf(4, 6, 9, 1)) { //1 -> 11월
            if (isAvail[i]) month30++
        }
        //31Month, 1 3 5 7 8 10 12
        var month31 = 0
        for (i in listOf(1, 3, 5, 7, 8, 10, 12)) {
            if (i == 10) {
                if (isAvail[1] && isAvail[0]) month31++
                continue
            }
            if (i == 12) {
                if (isAvail[1] && isAvail[2]) month31++
                continue
            }
            if (isAvail[i]) month31++
        }
        //29Month, 2
        val month29 = if (isAvail[2]) 1 else 0

//        sb.append("$day29 $day30 $day31 $month29 $month30 $month31 \n")
        var totalDay = 0
        totalDay += (day29 * month29 + day29 * month30 + day29 * month31)
        totalDay += (day30 * month30 + day31 * month31 + day30 * month31)
        sb.append("$totalDay\n")
    }
    print(sb)
}