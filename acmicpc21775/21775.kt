package acmicpc21775

import java.io.*
import java.util.*

/* 가희와 자원 놀이, 구현
https://www.acmicpc.net/problem/21775
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())

    val N = st.nextToken().toInt()
    val T = st.nextToken().toInt()

    st = StringTokenizer(bf.readLine())
    val turns = IntArray(T + 1) {
        if(it == 0) 0 else
        st.nextToken().toInt()
    }

    val sb = StringBuilder()
    val cardDeployed = HashMap<Int, Boolean>()
    val playerState = Array(N + 1) {
        CommandCard()
    }
    for(i in 1 .. T) {
        val player = turns[i]
        //if player카드가 있으면 그걸 실행
        if (playerState[player].hasCommand) {
            val isDeployed = cardDeployed.get(playerState[player].cardId) ?: false
            when (isDeployed) {
                true -> {
//                    sb.append("tried acquire but failed by saved ${playerState[player].cardId} ") // for debug
                    sb.append("${playerState[player].itemIndex} \n")
                }

                false -> {
//                    sb.append("acquired by saved ${playerState[player].cardId} ") // for debug
                    sb.append("${playerState[player].itemIndex}\n")
                    cardDeployed.put(playerState[player].cardId, true)
                    playerState[player].hasCommand = false
                }
            }
            continue
        }

        //else  ... 아래 실행.
        val st = StringTokenizer(bf.readLine())
        val itemIndex = st.nextToken().toInt()
        val cmd = st.nextToken()

        when (cmd) {
            "release" -> {
                val cardId = st.nextToken().toInt()
                cardDeployed.put(cardId, false)
//                sb.append("released by real data $cardId ") // for debug
                sb.append("$itemIndex\n")
            }

            "acquire" -> {
                val cardId = st.nextToken().toInt()
                val isDeployed = cardDeployed.get(cardId) ?: false
                when (isDeployed) {
                    true -> {
                        playerState[player].hasCommand = true
                        playerState[player].cardId = cardId
                        playerState[player].itemIndex = itemIndex
//                        sb.append("tried acquire by real data but failed $cardId ") // for debug
                        sb.append("$itemIndex\n")
                    }

                    false -> {
//                        sb.append("acquired by real data $cardId ") // for debug
                        sb.append("$itemIndex\n")
                        cardDeployed.put(cardId, true)
                    }
                }
            }

            else -> { //next
//                sb.append("passed  ") // for debug
                sb.append("$itemIndex\n")
            }
        }
    }
    print(sb)
}

data class CommandCard (
    var hasCommand : Boolean = false,
    var command : String = "",
    var cardId : Int = -1,
    var itemIndex : Int = -1)

/*

1 X passed 1
1 X acquire 1
2 X try acquire 1 but failed ... 2번이 [acquire 1] keep
2 O try acquire 1 but failed ... 2번이 [acquire 1] keep
1
1
2
2
2
2
 */