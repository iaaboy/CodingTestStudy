package acmicpc16197

import java.io.*
import java.util.*

/* 두 동전, 너비 우선 탐색
https://www.acmicpc.net/problem/16197
 */

private var N = 0
private var M = 0
private lateinit var map: Array<CharArray>
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    val inMap = Array(N) {
        bf.readLine().toCharArray()
    }
    map = Array(N + 2) {
        CharArray(M + 2) {
            'C'
        }
    }

    for (i in 0..<N) {
        for (j in 0..<M) {
            map[i + 1][j + 1] = inMap[i][j]
        }
    }

    val coin = ArrayList<Pair<Int, Int>>()
    for (i in 0..N) {
        for (j in 0..M) {
            if (map[i][j] == 'o') {
                coin.add(Pair(i, j))
                map[i][j] = '.'
            }
        }
    }

//    for (chars in map) {
//        println(chars)
//    }

    val debugStack = Stack<Int>()
    move(debugStack, 0, coin[0].first, coin[0].second, coin[1].first, coin[1].second)

    if (minCount == Int.MAX_VALUE) minCount = -1
    println(minCount)
}

private val dx = intArrayOf(1, 0, 0, -1)
private val dy = intArrayOf(0, 1, -1, 0)
private var minCount = Int.MAX_VALUE
private fun move(debugStack: Stack<Int>, count: Int, y1: Int, x1: Int, y2: Int, x2: Int) {

//    println("$count, ($y1 $x1) , ($y2 $x2)")

    if (count == 10 || count > minCount) return

    for (i in 0 until 4) {
        var nx1 = x1 + dx[i]
        var ny1 = y1 + dy[i]

        var nx2 = x2 + dx[i]
        var ny2 = y2 + dy[i]

        //coin 다음 위치
        if (((map[ny1][nx1] == 'C') && (map[ny2][nx2] != 'C')) ||
            ((map[ny1][nx1] != 'C') && (map[ny2][nx2] == 'C'))
        ) {
            //완료
            if (count + 1 < minCount) {
//                println(debugStack)
                minCount = count + 1
            }
            continue
        }

        if (map[ny1][nx1] == 'C') continue
        if (map[ny2][nx2] == 'C') continue

        if (map[ny1][nx1] == '#') {
            nx1 = x1
            ny1 = y1
        }
        if (map[ny2][nx2] == '#') {
            nx2 = x2
            ny2 = y2
        }
        if (ny1 == ny2 && nx1 == nx2) continue

//        debugStack.add(i)
        move(debugStack, count + 1, ny1, nx1, ny2, nx2)
//        debugStack.pop()
    }
}
