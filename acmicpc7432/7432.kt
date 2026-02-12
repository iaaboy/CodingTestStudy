package acmicpc7432

import java.io.*

/* 디스크 트리, Trie
https://www.acmicpc.net/problem/7432
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()

    val root = Trie()

    repeat(N) {
        val dir = bf.readLine().split("\\")
        val length = dir.size

        fun traverse(cur: Trie, depth: Int, printAlias: Boolean) {
            if (depth == length) {
                return
            }
            val key = dir.get(depth)
            if (cur.child.containsKey(dir.get(depth))) {
                val next = cur.child.get(key)
                traverse(next!!, depth + 1, false)
            } else {
                val next = Trie()
                cur.child.put(key, next)
                traverse(next, depth + 1, printAlias)
            }
        }
        traverse(root, 0, true)
    }

    val sb = StringBuilder()
    fun travel(cur: Trie, prefix: String) {
        for (key in cur.child.keys.toList().sorted()) {
            sb.append(prefix).append(key).append("\n")
            travel(cur.child.get(key)!!, "$prefix ")
        }
    }
    travel(root, "")
    print(sb)
}

private class Trie(val child: HashMap<String, Trie> = HashMap())

/*
3
WINNT\SYSTEM32\CONFIG
GAMES
WINNT\DRIVERS
*/

/*
A
 A
  A
   A
 AA
  A
   AA
 AAA
  AAA
AA
 A
  AAAA
 AA
  AA
   AA
 AAA
AAA
 A
  AAAA
 AA
  AAA
 AAA
  AAA
   AAA
AAAA
 AAAA
  AAAA
   AAAA
 */