package acmicpc34075

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs

/* 세그먼트 트리보다도 바･로･너･♡
https://www.acmicpc.net/problem/34075
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val algoMap = ArrayList<Pair<Int, String>>()
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        val name = st.nextToken()
        val difficulty = st.nextToken().toInt()
        algoMap.add(Pair(difficulty, name))
    }

    val M = bf.readLine().toInt()
    val member = HashMap<String, Pair<String,String>> ()
    repeat(M) {
        val st = StringTokenizer(bf.readLine())
        val name = st.nextToken()
        val level = st.nextToken().toInt()
        var minName = ""
        var minDiff = Integer.MAX_VALUE
        for (entry in algoMap) {
            val diffAbs = abs(level - entry.first)
            if (diffAbs < minDiff) {
                minName = entry.second
                minDiff = diffAbs
            } else if (diffAbs  == minDiff) {
                if (minName > entry.second) {
                    minName = entry.second
                    minDiff = diffAbs
                }
            }
        }
        var minName2 = ""
        var minDiff2 = Integer.MAX_VALUE
        for (entry in algoMap) {
            if (entry.second == minName) continue
            val diffAbs = abs(level - entry.first)
            if (diffAbs < minDiff2) {
                minName2 = entry.second
                minDiff2 = diffAbs
            } else if (abs(level - entry.first)  == minDiff2) {
                if (minName2 > entry.second) {
                    minName2 = entry.second
                    minDiff2 = diffAbs
                }
            }
        }
        member.put(name, Pair(minName, minName2))
    }

    val Q = bf.readLine().toInt()
    val sb = StringBuilder()
    var lastCalledName = ""
    repeat(Q) {
        val call = bf.readLine()
        if (!call.contains("nani ga suki?")) {
            sb.append("hai!\n")
            lastCalledName = call.replace(" - chan!", "")
        } else {
            val myAlgol = member.get(lastCalledName)
            sb.append("${myAlgol?.second} yori mo ${myAlgol?.first}\n")
        }
    }
//    sb.append(member)
    println(sb)

}
