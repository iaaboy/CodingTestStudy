package acmicpc17394

import java.io.*
import java.util.*

/* 핑거 스냅 풀이
https://www.acmicpc.net/problem/17394
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val maxNum = 1000000
    val eratos = BooleanArray(maxNum + 1)
    for (i in 2..maxNum / 2) {
        var j = i * 2
        while (j <= maxNum) {
            if (!eratos[j]) {
                eratos[j] = true // 소수가 아님.
            }
            j += i
        }
    }
    val sb = StringBuilder()

    repeat(T) {
        val st = StringTokenizer(bf.readLine())
        val N = st.nextToken().toInt() // 시작점
        val A = st.nextToken().toInt() // 목표 범위 A ~ B
        val B = st.nextToken().toInt()
        val numSet = HashSet<Int>()
        for (i in A .. B) {
            if (!eratos[i]) numSet.add(i)
        }
        if (numSet.contains(N)) {
            sb.append("0\n")
        } else if (numSet.isEmpty()) {
            sb.append("-1\n")
        } else {
            val visit = BooleanArray(maxNum + 1)
            val q = ArrayDeque<Snap>()
            q.add(Snap(N, 0))
            visit[N] = true
            while (q.isNotEmpty()) {
                val cur = q.poll()
                var next = cur.num / 2
                if (numSet.contains(next)) {
                    sb.append("${cur.count + 1}\n")
                    break
                } else if (next >= 2 && next <= maxNum && !visit[next]) {
                    visit[next] = true
                    q.add(Snap(next, cur.count + 1))
                }
                next = cur.num / 3
                if (numSet.contains(next)) {
                    sb.append("${cur.count + 1}\n")
                    break
                } else if (next >= 2 && next <= maxNum && !visit[next]) {
                    visit[next] = true
                    q.add(Snap(next, cur.count + 1))
                }
                next = cur.num + 1
                if (numSet.contains(next)) {
                    sb.append("${cur.count + 1}\n")
                    break
                } else if (next >= 2 && next <= maxNum && !visit[next]) {
                    visit[next] = true
                    q.add(Snap(next, cur.count + 1))
                }
                next = cur.num - 1
                if (numSet.contains(next)) {
                    sb.append("${cur.count + 1}\n")
                    break
                } else if (next >= 2 && next <= maxNum && !visit[next]) {
                    visit[next] = true
                    q.add(Snap(next, cur.count + 1))
                }
            }
        }
    }

    print(sb)
}
data class Snap(val num : Int, val count : Int)