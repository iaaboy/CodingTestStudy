package acmicpc27964

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val wordSet = HashSet<String>()
    val st = StringTokenizer(bf.readLine())
    repeat(N) {
        val word = st.nextToken()
        if (word.endsWith("Cheese", ignoreCase = false)) {
            wordSet.add(word)
        }
    }
    val result = when(wordSet.size >= 4) {
        true -> "yummy"
        false -> "sad"
    }
    println(result)
}