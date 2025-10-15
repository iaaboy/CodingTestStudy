package acmicpc4374

import java.io.*
import java.util.*

/* 지프의 법칙
https://www.acmicpc.net/problem/4374
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val numberString = bf.readLine()
        if (numberString.isNullOrEmpty()) {
            return
        }
        val N = numberString.toInt()
        var sentence = bf.readLine().lowercase()
        val count = TreeMap<String, Int>()
        while (!"endoftext".contentEquals(sentence)) {
            sentence += " "
            var sb = StringBuilder()
            for (ch in sentence) {
                when (ch) {
                    in 'a'..'z' -> sb.append(ch)
                    else -> {
                        if (!sb.isEmpty()) {
//                        println(sb)
                            count[sb.toString()] = count.getOrDefault(sb.toString(), 0) + 1
                            sb = StringBuilder()
                        }
                    }
                }
            }
            sentence = bf.readLine().lowercase()
        }
        val sb = StringBuilder()
        for (entry in count) {
            if (entry.value == N) {
                sb.append(entry.key).append("\n")
            }
        }
        if (sb.isEmpty()) {
            sb.append("There is no such word.\n")
        }
        sb.append("\n")
        print(sb)
    }
//    println(count)
}