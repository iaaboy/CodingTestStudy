package acmicpc16738

import java.io.*
import java.util.*

var Q = 0
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    Q = st.nextToken().toInt()
    val isFull = BooleanArray(N + 1)
    val rooms : Array<Room> = Array(
        Q + 2
    ) {
        Room()
    }
    var nextId = 1
    val sb = StringBuilder()

    fun findIndex(size: Int): Int {
        var cnt = 0
        for (i in 1..N) {
            if (isFull[i]) {
                cnt = 0
            } else {
                cnt++
                if (cnt == size) {
                    return i - size + 1
                }
            }
        }
        return -1
    }

    repeat(Q) {
        st = StringTokenizer(bf.readLine())
        val cmd = st.nextToken()
        val X = st.nextToken().toInt()
        val Y = st.nextToken().toInt()
        when {
            cmd.contentEquals("new") -> {
                val people = X
                val size = Y

                val start = findIndex(size)
                if (start == -1) {
                    sb.append("REJECTED\n")
                } else {
                    val end = start + size - 1

                    // 방 점유 표시
                    for (i in start..end) {
                        isFull[i] = true
                    }

                    // 팀 정보 저장
                    rooms[nextId].left = start
                    rooms[nextId].right = end
                    rooms[nextId].people = people

                    sb.append(start).append(' ').append(end).append('\n')
                    nextId++
                }
            }
            cmd.contentEquals("in") -> {
                val id = X
                val plus = Y
                rooms[id].people += plus
            }
            cmd.contentEquals("out") -> {
                val id = X
                val minus = Y
                val r = rooms[id]
                r.people -= minus

                if (r.people == 0) {
                    // 전부 퇴실 → 청소 + 방 비우기
                    for (i in r.left..r.right) {
                        isFull[i] = false
                    }
                    sb.append("CLEAN ")
                        .append(r.left)
                        .append(' ')
                        .append(r.right)
                        .append('\n')
                }
            }
        }
    }
    print(sb)
}

data class Room (var left: Int = 0, var right:Int = 0, var people:Int = 0)