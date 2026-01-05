package acmicpc14226

import java.io.*
import java.util.*

/* 이모티콘, 너비 우선 탐색
https://www.acmicpc.net/problem/14226
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val S = bf.readLine().toInt()

    val q = PriorityQueue<State> { a,b -> a.stepCount - b.stepCount}
    q.add(State(1, 0, 0))

    val visit = Array(4000) {
        BooleanArray(4000)
    }

    while (q.isNotEmpty()) {
        val c = q.poll()

//        println(c)

        if (c.emojiCount == S) {
            println(c.stepCount)
            break
        }

        if (!visit[c.emojiCount][c.emojiCount]) {
            visit[c.emojiCount][c.emojiCount]
            q.add(State(c.emojiCount, c.emojiCount, c.stepCount + 1))
        }
        //붙여넣기
        if (c.emojiCount + c.clipboard < 4000 && !visit[c.emojiCount + c.clipboard][c.clipboard]) {
            visit[c.emojiCount + c.clipboard][c.clipboard] = true
            q.add(State(c.emojiCount + c.clipboard, c.clipboard, c.stepCount + 1))
        }
        //하나 삭제
        if (c.emojiCount - 1 > 0 && (!visit[c.emojiCount - 1][c.clipboard])) {
            visit[c.emojiCount - 1][c.clipboard] = true
            q.add(State(c.emojiCount - 1, c.clipboard, c.stepCount + 1))
        }
    }

}
private data class State (val emojiCount : Int, val clipboard : Int, val stepCount : Int)
