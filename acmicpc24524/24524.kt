package acmicpc24524

import java.io.*
import java.util.Stack

/* 아름다운 문자열, stack 그리디
https://www.acmicpc.net/problem/24524
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val S = bf.readLine().toCharArray()
    val T = bf.readLine().toCharArray()

    val indexMap = HashMap<Char, Stack<Int>>()
    for (i in 0 ..< T.size) {
        indexMap.put(T[i], Stack<Int>())
    }
    for (i in S.size - 1 downTo 0) {
        indexMap.get(S[i])?.add(i)
    }

//    println("Test log")
//    for (entry in indexMap.entries) {
//        println("${entry.key} ${entry.value}")
//    }

    var count = 0

    fun getNum(index : Int)  = indexMap[T[index]]?.let {
            if(it.isNotEmpty()) {
                it.pop()
            } else {
                -1
            }
        }  ?: -1

    loop@while (true) {
        var prev = getNum(0)
        if (prev == -1) {
            break@loop
        }
        for (i in 1 ..< T.size) {
            var cur = getNum(i)
            if (cur == -1) {
                break@loop
            }
            while (prev > cur) {
                cur = getNum(i)
                if (cur == -1) {
                    break@loop
                }
            }
            prev = cur
        }
//        println(++count)
        count++
    }

//    println("finish")
    println(count)
}

/*
abbcacb
abc

saassa
sa

abbcbacbb
abc

aabb
ab
 */