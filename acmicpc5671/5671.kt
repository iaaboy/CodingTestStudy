package acmicpc5671

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val isOk = BooleanArray(5001)
    for (i in 1 .. 5000) {
        isOk[i] = isOk(i)
    }
    val sb = StringBuilder()
    while (true) {
        val line = bf.readLine() ?: break
        if (line.isBlank()) break
        val st = StringTokenizer(line)
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        var count = 0
        for (i in a .. b) {
            if(isOk[i]) count++
        }
        sb.append("$count\n")
    }
    println(sb)
}

fun isOk(num: Int) : Boolean {
    val numString = num.toString()
    val count: Long = numString.chars()
        .distinct()
        .count()
    return numString.length == count.toInt()
}
