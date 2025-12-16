package acmicpc5648

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    var n = st.nextToken().toInt()
    val numbers = ArrayList<Long>(n)
    while (true) {
        while (st.hasMoreTokens()) {
            val numString = st.nextToken()
            numbers.add(numString.reversed().toLong())
            n--
            if (n == 0) {
                val sb = StringBuilder()
                for (i in numbers.sorted()) {
                    sb.append("$i\n")
                }
                print(sb)
                return
            }
        }
        st = StringTokenizer(bf.readLine())
    }

}