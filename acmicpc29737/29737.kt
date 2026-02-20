package acmicpc29737

import java.io.*
import java.util.*

/* 브실이는 잔디가 좋아, 구현 정렬
https://www.acmicpc.net/problem/29737
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val W = st.nextToken().toInt()
    val totalDay = W * 7
    repeat(N) {
        val name = bf.readLine()
        val record = CharArray(totalDay + 1)
        for (d in 0 until 7) {
            val data = bf.readLine().toCharArray()
            for (w in 0 until data.size) {
                val index = d + 7 * w
                record[index] = data[w]
            }
        }
        record[totalDay] = 'X'
//        println(map.joinToString(" "))

        val playerRecords = ArrayList<Player>()

        var recordStreak = 0
        var recordFreeze = 0
        var recordFail = 0

        var streakCount = 0
        var freezeCount = 0
        var startDate = 0
        for (i in 0..totalDay) {
            if (record[i] == 'X') {
                recordStreak = maxOf(recordStreak, streakCount)
                recordFreeze = maxOf(recordFreeze, freezeCount)

                startDate = i + 1
                freezeCount = 0
                streakCount = 0

                recordFail++
            } else if (record[i] == 'F') {
                freezeCount++
            }
        }

        playerRecords.add(Player(name, recordStreak, recordFreeze, startDate, recordFail))

        playerRecords.sortWith { a, b ->
            if (a.streak == b.streak) {
                if (a.freeze == b.freeze) {
                    if (a.startDay == b.startDay) {
                        if (a.failCount == b.failCount) {
                            a.name.compareTo(b.name)
                        } else {
                            a.failCount - b.failCount//스트릭 프리즈 사용한 날짜를 제외하고 스트릭 달성에 실패한 날짜 수가 적은 친구
                        }
                    } else {
                        a.startDay - b.startDay//최장 스트릭을 시작한 날짜가 더 이른 친구
                    }
                } else {
                    a.freeze - b.freeze//최장 스트릭 내의 더 적은 개수의 스트릭 프리즈를 사용한 친구
                }
            } else {
                b.streak - a.streak//가장 긴 최장 스트릭을 가진 친구
            }
        }

        println(playerRecords)

    }
}

private data class Player(
    val name: String,
    val streak: Int,
    val freeze: Int,
    val startDay: Int,
    val failCount: Int
)
