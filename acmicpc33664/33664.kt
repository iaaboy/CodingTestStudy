package acmicpc33664

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    var B = st.nextToken().toLong()
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val items = HashMap<String, Long>()
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        items.put(st.nextToken(), st.nextToken().toLong())
    }

    repeat(M) {
        val key = bf.readLine()
        val value = items.get(key) ?: 0
        B -= value
    }

    when {
        B >= 0 -> {
            println("acceptable")
        }
        else -> {
            println("unacceptable")
        }
    }
}