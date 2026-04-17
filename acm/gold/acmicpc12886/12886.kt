package acm.gold.acmicpc12886

import java.util.ArrayDeque
import java.util.StringTokenizer

/* 돌 그룹 , 너비 우선 탐색.
https://www.acmicpc.net/problem/12886
 */

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    // 강호는 돌을 단계별로 움직이며, 각 단계는 다음과 같이 이루어져 있다.

    // 크기가 같지 않은 두 그룹을 고른다. 그 다음, 돌의 개수가 작은 쪽을 X, 큰 쪽을 Y라고 정한다.
    // 그 다음, X에 있는 돌의 개수를 X+X개로, Y에 있는 돌의 개수를 Y-X개로 만든다.

    val sum = a + b + c
    val maxLimit = sum
    val visit = Array(maxLimit + 1) {
        BooleanArray(maxLimit + 1)
    }

    val queue = ArrayDeque<State>()
    val startA = minOf(a, b)
    val startB = maxOf(a, b)

    queue.add(State(startA, startB))
    visit[startA][startB] = true

    fun move(
        x: Int,
        y: Int,
        visit: Array<BooleanArray>,
        queue: ArrayDeque<State>
    ) {
        if (x == y) return

        val small = minOf(x, y)
        val big = maxOf(x, y)

        val nx = small * 2
        val ny = big - small

        val a = minOf(nx, ny)
        val b = maxOf(nx, ny)

        if (!visit[a][b]) {
            visit[a][b] = true
            queue.add(State(a, b))
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        val a = current.a
        val b = current.b
        val c = sum - a - b

        if (a == b && b == c) {
            println(1)
            return
        }
        move(a, b, visit, queue)
        move(a, c, visit, queue)
        move(b, c, visit, queue)
    }

    println(0) // 도달하지 못한 경우

}


data class State(val a: Int, val b: Int)