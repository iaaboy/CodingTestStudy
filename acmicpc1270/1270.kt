package acmicpc1270

import java.io.*
import java.util.*

/* 전쟁 - 땅따먹기, 해시
https://www.acmicpc.net/problem/1270
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(n) {
        val st = StringTokenizer(bf.readLine())
        val t = st.nextToken().toInt()
        val numMap = HashMap<Long, Long>()
        (0 until t).forEach { i ->
            val key = st.nextToken().toLong()
            numMap.put(key, numMap.getOrDefault(key, 0) + 1)
        }
        var isConquered = false
        var key = 0L
        for (entry in numMap.entries) {
            if (entry.value > t / 2) {
                isConquered = true
                key = entry.key
            }
        }
        when (isConquered) {
            true -> sb.append("$key\n")
            false -> sb.append("SYJKGW\n")
        }
    }
    print(sb)
}