package acmicpc16934

import java.io.*

/* 풀이중.
https://www.acmicpc.net/problem/16934
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()

    val tries = ArrayList<Trie>()
    tries.add(Trie())
    val root = tries[0]
    repeat(N) {
        val chaArr = bf.readLine().toCharArray()
        val length = chaArr.size

        fun traverse(cur: Trie, depth: Int, printAlias : Boolean) {
            if (depth == length) {
                if (printAlias) {
                    println("${chaArr.joinToString("")} $depth")
                }
                return
            }
            val number = chaArr[depth] - 'a'
            if(cur.child[number] == -1) {
                val next = Trie()
                tries.add(next)
                cur.child[number] = tries.size - 1
                if (printAlias) {
                    println("${chaArr.joinToString("")} $depth")
                }
                traverse(next, depth + 1, false)
            } else {
                val next =  tries.get(cur.child[number])
                traverse(next, depth + 1, printAlias)
            }
        }

        traverse(root, 0, true)
    }
}

private class Trie(val child: IntArray = IntArray(26) { -1 }, val count : Int = 1)