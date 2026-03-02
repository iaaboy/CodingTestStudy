package acmicpc27084

import java.io.*
import java.util.StringTokenizer

const val MOD = 1_000_000_007L

/* 카드 뽑기, 수학
https://www.acmicpc.net/problem/27084
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    val map = HashMap<Long, Long>()

    repeat(N) {
        val x = st.nextToken().toLong()
        map[x] = map.getOrDefault(x, 0L) + 1
    }

    var answer = 1L

    for (freq in map.values) {
        answer = (answer * (freq + 1)) % MOD
    }

    // 공집합 제거
    answer = (answer - 1 + MOD) % MOD

    println(answer)
}
