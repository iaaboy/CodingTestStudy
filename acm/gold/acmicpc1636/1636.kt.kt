package acm.gold.acmicpc1636

import java.util.*

/* 한번 열면 멈출 수 없어, 애드혹
https://www.acmicpc.net/problem/1636
 */
fun main() {
    val N = readln().toInt()
    val eats = ArrayList<Area>() //중독 스트레스 조절 범위.
    repeat(N) {
        val st = StringTokenizer(readln())
        eats.add(Area(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    var s = 0
    var e = 100000
//    println("$s $e")
    var moveSum = 0
    var move: Int
    val areas = Stack<Area>()
    for (a in eats) {
        //  |   s   e   |
        if (a.s <= s && e <= a.e) {
            //do nothing

//            move = 0
//            print("case 1 $move : ")
        }
        //  s     |    |    e
        else if (s <= a.s && a.e <= e) {
            s = a.s
            e = a.e
//            move = 0
//            print("case 2 $move : ")
        }
        //    s     |     e    |
        else if (a.s in s..e) {
            s = a.s
//          e = e
//            move = 0
//            print("case 3 $move : ")
        }

        //  |   s    |   e
        else if (s in a.s..a.e) {
            //s = s
            e = a.e
//            move = 0
//            print("case 4 $move: ")
        }

        //  s    e   |     |
        else if (e <= a.s) {
            move = a.s - e
            s = a.s
            e = a.s
            moveSum += move
//            print("case 5 $move : ")
        }

        //   |    |     s   e
        else if (a.e <= s) {
            move = s - a.e
            s = a.e
            e = a.e
            moveSum += move
//            print("case 6 $move : ")
        }
//        println("$s $e")
        areas.add(Area(s, e))
    }
    val points = ArrayList<Int>()
    var prevPoint = areas.pop().s
    points.add(prevPoint)
    while (areas.isNotEmpty()) {
        val cur = areas.pop()
        if (prevPoint >= cur.e) {
            prevPoint = cur.e
        } else if (prevPoint <= cur.s) {
            prevPoint = cur.s
        } else {
            //keep
        }
        points.add(prevPoint)
    }
    val sb = StringBuilder()
    sb.append(moveSum).append("\n")
    points.reversed().forEach { sb.append(it).append("\n") }
    print(sb)
}

data class Area(val s: Int, val e: Int)

/*
[1, 100]
[50, 60]
[1, 100]

3
1 100
50 60
1 100

3
5 10
20 30
30 31
 */