package acmicpc16934

import java.io.*

/* 게임 닉네임, TRIE
https://www.acmicpc.net/problem/16934
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val tries = ArrayList<Trie>()
    tries.add(Trie())
    val root = tries[0]
    val sb = StringBuilder()
    repeat(N) {
        val chaArr = bf.readLine().toCharArray()
        val length = chaArr.size
        fun traverse(cur: Trie, depth: Int, printAlias: Boolean) {
            if (depth == length) {
                cur.count++
                if (printAlias) {
                    if (cur.count <= 1) {
                        sb.append(chaArr.joinToString("")).append("\n")
                    } else {
                        sb.append("${chaArr.joinToString("")}${cur.count}\n")
                    }
                }
                return
            }
            val number = chaArr[depth] - 'a'
            if (cur.child[number] == -1) {
                val next = Trie()
                tries.add(next)
                cur.child[number] = tries.size - 1
                if (printAlias) {
                    for (i in 0..depth) {
                        sb.append(chaArr[i])
                    }
                    sb.append("\n")
                }
                traverse(next, depth + 1, false)
            } else {
                val next = tries.get(cur.child[number])
                traverse(next, depth + 1, printAlias)
            }
        }
        traverse(root, 0, true)
    }
    print(sb)
}

private class Trie(val child: IntArray = IntArray(26) { -1 }, var count: Int = 0)
