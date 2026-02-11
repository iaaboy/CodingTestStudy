package acmicpc5052

import java.io.*

/* 전화번호 목록, TRIE
https://www.acmicpc.net/problem/5052
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val N = bf.readLine().toInt()

        val tries = ArrayList<Trie>()
        tries.add(Trie())
        val root = tries[0]

        var result = true
        repeat(N) {
            val chaArr = bf.readLine().toCharArray()
            val length = chaArr.size

            fun traverse(cur: Trie, depth: Int, isNewCreate : Boolean) {
                if (depth == length) {
                    cur.occupied = true
                    if (!isNewCreate) {
                        result = false
                    }
                    return
                }
                val number = chaArr[depth] - '0'
                if(cur.child[number] == -1) {
                    val next = Trie()
                    tries.add(next)
                    cur.child[number] = tries.size - 1
                        traverse(next, depth + 1, true)
                } else {
                    val next =  tries.get(cur.child[number])
                    if (next.occupied) {
                        result = false
                    }
                    traverse(next, depth + 1, false)
                }
            }

            if (result) {
                traverse(root, 0, false)
            }
        }
        when (result) {
            true -> sb.append("YES\n")
            false -> sb.append("NO\n")
        }
    }
    println(sb)
}

private class Trie(var occupied: Boolean = false, val child: IntArray = IntArray(10) { -1 })
