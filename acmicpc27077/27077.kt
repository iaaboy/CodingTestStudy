package acmicpc27077

import java.util.StringTokenizer

/* 16강과 쿼리, 구현, 정렬
https://www.acmicpc.net/problem/27077
 */

fun main() {
    var st = StringTokenizer(readLine())
    val state = HashMap<String, State>()
    val KOR = "korea"
    val URG = "uruguay"
    val GHA = "ghana"
    val POR = "portugal"
    state.put(KOR, State(KOR, st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    st = StringTokenizer(readLine())
    state.put(URG, State(URG, st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    st = StringTokenizer(readLine())
    state.put(GHA, State(GHA, st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    st = StringTokenizer(readLine())
    state.put(POR, State(POR, st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    val N = readLine()?.toInt() ?: 0

    val arr = ArrayList<State>()
    for (item in state.values) {
        arr.add(item)
    }

    //한국-포르투갈전과 가나-우루과이전

    fun getState(): String {

        val kor = state[KOR]?.goal ?: 0
        val por = state[POR]?.goal ?: 0
        val ghana = state[GHA]?.goal ?: 0
        val uru = state[URG]?.goal ?: 0

        if (kor == por) {
            state[KOR]?.let {
                it.currentWinPoint = it.initialWinPoint + 1
            }
            state[POR]?.let {
                it.currentWinPoint = it.initialWinPoint + 1
            }
        } else if (kor > por) {
            state[KOR]?.let {
                it.currentWinPoint = it.initialWinPoint + 3
            }
            state[POR]?.let {
                it.currentWinPoint = it.initialWinPoint
            }
        } else {
            state[KOR]?.let {
                it.currentWinPoint = it.initialWinPoint
            }
            state[POR]?.let {
                it.currentWinPoint = it.initialWinPoint + 3
            }
        }
        if (ghana == uru) {
            state[GHA]?.let {
                it.currentWinPoint = it.initialWinPoint + 1
            }
            state[URG]?.let {
                it.currentWinPoint = it.initialWinPoint + 1
            }
        } else if (ghana > uru) {
            state[GHA]?.let {
                it.currentWinPoint = it.initialWinPoint + 3
            }
            state[URG]?.let {
                it.currentWinPoint = it.initialWinPoint
            }
        } else {
            state[GHA]?.let {
                it.currentWinPoint = it.initialWinPoint
            }
            state[URG]?.let {
                it.currentWinPoint = it.initialWinPoint + 3
            }
        }

        arr.sortWith(compareByDescending<State> { it.currentWinPoint }
            .thenByDescending { it.win - it.lose }
            .thenByDescending { it.win }
        )

        for ((index, item) in arr.withIndex()) {
            if (item.country.contentEquals(KOR)) {
                if (index <= 1 &&
                    (item.currentWinPoint != arr.get(2).currentWinPoint ||
                            item.win != arr.get(2).win || item.lose != arr.get(2).lose)
                    ) {
                    return "cry\n"
                } else {
                    return "unhappy\n"
                }
            }
        }
        return ""
    }

    val sb = StringBuilder()
    sb.append(getState())

    repeat(N) {
        val country = readLine()
        when (country) {
            KOR -> {
                state[KOR]!!.win++
                state[KOR]!!.goal++
                state[POR]!!.lose++
            }

            URG -> {
                state[URG]!!.win++
                state[URG]!!.goal++
                state[GHA]!!.lose++
            }

            GHA -> {
                state[GHA]!!.win++
                state[GHA]!!.goal++
                state[URG]!!.lose++
            }

            POR -> {
                state[POR]!!.win++
                state[POR]!!.goal++
                state[KOR]!!.lose++
            }
        }

        //동호가 눈물을 흘리면 cry, 불행하면 unhappy를 출력
        sb.append(getState())
    }

    print(sb)
//
//    for (item in arr) {
//        println(item)
//    }
}

data class State(
    val country: String,
    var win: Int, //득점
    var lose: Int, //실점
    var initialWinPoint: Int, //초기 승점
    var goal: Int = 0,
    var currentWinPoint: Int = 0 //중간 승점
)
