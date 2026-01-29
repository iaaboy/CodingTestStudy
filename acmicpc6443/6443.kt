package acmicpc6443

import java.io.*
import java.util.*

/* 애너그램 , 백트래킹
https://www.acmicpc.net/problem/6443
 */

lateinit var word: CharArray
val treeSet = TreeSet<String>()

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(N) {
        word = bf.readLine().toCharArray()
        word.sort()
        val visit = BooleanArray(word.size)
        val index = IntArray(word.size) {
            it
        }
        pelin(index, visit, 0)
        sb.append(treeSet.joinToString("\n"))
        sb.append("\n")
        print(sb)
        sb.clear()
        treeSet.clear()
    }
    //print(sb)
}
private fun pelin(index: IntArray, visit: BooleanArray, depth: Int) {
    if (depth == visit.size) {
        val sb = StringBuilder()
        for (i in index) {
            sb.append(word[i])
        }
        treeSet.add(sb.toString())
        return
    }
    var prevChar = '\u0000'
    for (i in 0..<index.size) {
        if (visit[i] || word[i] == prevChar) continue
        visit[i] = true
        index[depth] = i
        pelin(index, visit, depth + 1)
        prevChar = word[i]
        visit[i] = false
    }
}