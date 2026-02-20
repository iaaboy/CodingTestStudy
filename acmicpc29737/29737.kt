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
    val playerRecords = ArrayList<Player>()

    fun comparePlayer(a: Player, b: Player, withName: Boolean = true) =
        if (a.streak == b.streak) {
            if (a.freeze == b.freeze) {
                if (a.startDay == b.startDay) {
                    if (a.failCount == b.failCount) {
                        if (withName) {
                            a.name.compareTo(b.name)
                        } else {
                            0
                        }
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

        fun countLastF(index: Int): Int {
            var countF = 0
            for (i in index downTo 0) {
                if (record[i] == 'F') {
                    countF++
                } else {
                    break
                }
            }
            return countF
        }

        var maxPlayRecord: Player? = null
        var player = Player(name, 0, 0, 0, 0)
        var failCount = 0
        for (i in 0..totalDay) {
            if (record[i] == 'X') {
                val lastF = countLastF(i - 1)
                player.freeze -= lastF
                if (maxPlayRecord == null || comparePlayer(maxPlayRecord, player, false) > 0) {
                    maxPlayRecord = player
                }

                player = Player(name, 0, 0, i + 1, 0)
                failCount++
            } else if (record[i] == 'F') {
                if (player.streak == 0) {
                    player.startDay++
                } else {
                    player.freeze++
                }
            } else { //'O'
                player.streak++
            }
        }
        maxPlayRecord?.let {
            it.failCount = failCount
            playerRecords.add(it)
        }
    }

    playerRecords.sortWith { a, b ->
        comparePlayer(a, b)
    }

    var position = 1
    for (i in 0 until N) {
        if (i != 0) {
            if (comparePlayer(playerRecords[i], playerRecords[i - 1], false) != 0) {
                position++
            }
        }

//        println("${position}. ${playerRecords[i]}")

        println("${position}. ${playerRecords[i].name}")
    }
}

private data class Player(
    val name: String,
    var streak: Int,
    var freeze: Int,
    var startDay: Int,
    var failCount: Int
)

/*
2 1
zpswgl
F
O
O
O
O
O
O
yepooj
O
O
O
O
O
F
O

2 1
huq
F
O
O
X
O
F
O
exkiazs
O
O
X
O
X
O
O

2 7
tslwlud
XOFXOOX
OOOOOOO
XXOXOXO
XOXXFOF
OOOOXOO
OOXOOOX
OOOOOFO
xqrdr
OFFXOOX
XXFOOXX
OOFFOXX
FOXXOXO
OXXXXFF
XOFOOOX
OXFOXXO


2 1
zpswgl
O
F
O
X
O
O
O
yepooj
F
O
O
O
X
X
X

2 1
wnyfr
F
F
O
O
O
O
O
qrcmqa
O
X
O
O
O
O
O


 */