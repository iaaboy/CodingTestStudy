package acm.gold.acmicpc31806

import java.util.PriorityQueue
import java.util.StringTokenizer

/* 구조대, 슬라이딩 윈도우
https://www.acmicpc.net/problem/31806
 */

fun main() {
    val st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val teamInfos = HashMap<Int, ArrayList<Team>>()

    repeat(N) {
        val st = StringTokenizer(readln())
        val l = st.nextToken().toInt()
        val r = st.nextToken().toInt()
        val id = st.nextToken().toInt()

        teamInfos.computeIfAbsent(id) { ArrayList() }
        teamInfos[id]!!.add(Team(id, l, r))
    }

    val refinedInfo = ArrayList<Team>()

    for (teams in teamInfos.values) {
        teams.sortBy { it.start }

        for (i in 0 until teams.size - 1) {
            // M 조건
            if (teams[i + 1].start - teams[i].end > M) continue

            val start = teams[i].end - 1
            val end = teams[i + 1].start

            refinedInfo.add(Team(teams[i].id, start, end))
        }
    }

    // 핵심: end 기준 정렬
    refinedInfo.sortBy { it.end }

    // PQ: start 기준 최소 힙
    val pq = PriorityQueue<Node>(compareBy { it.start })

    val count = HashMap<Int, Int>()
    var currentTeams = 0
    var answer = 0

    for (seg in refinedInfo) {
        val R = seg.end

        // 추가
        pq.add(Node(seg.start, seg.id))
        count[seg.id] = count.getOrDefault(seg.id, 0) + 1
        if (count[seg.id] == 1) currentTeams++

        // 제거
        while (pq.isNotEmpty() && pq.peek().start < R - M) {
            val removed = pq.poll()
            count[removed.id] = count[removed.id]!! - 1
            if (count[removed.id] == 0) currentTeams--
        }

        // 정답 갱신
        answer = maxOf(answer, currentTeams)
    }

    println(answer)
}

data class Team(val id: Int, val start: Int, val end: Int)
data class Node(val start: Int, val id: Int)

/*
5 10
1 5 1
6 7 1
2 5 2
9 10 1
11 12 2

4 4
1 5 1
2 5 2
6 7 1
11 12 2
 */