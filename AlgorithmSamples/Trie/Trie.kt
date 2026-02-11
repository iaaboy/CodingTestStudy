package AlgorithmSamples.Trie

class Trie {

    private class TrieNode {
        val child = Array<TrieNode?>(26) { null }
        var isEnd = false
    }

    private val root = TrieNode()

    // 단어 삽입
    fun insert(word: String) {
        var cur = root

        for (ch in word) {
            val idx = ch - 'a'
            if (cur.child[idx] == null) {
                cur.child[idx] = TrieNode()
            }
            cur = cur.child[idx]!!
        }

        cur.isEnd = true
    }

    // 단어 존재 여부
    fun search(word: String): Boolean {
        val node = findNode(word)
        return node?.isEnd == true
    }

    // prefix 존재 여부
    fun startsWith(prefix: String): Boolean {
        return findNode(prefix) != null
    }

    // 공통 탐색 로직
    private fun findNode(s: String): TrieNode? {
        var cur = root

        for (ch in s) {
            val idx = ch - 'a'
            cur = cur.child[idx] ?: return null
        }

        return cur
    }
}

fun main() {
    val trie = Trie()

    trie.insert("apple")
    trie.insert("app")
    trie.insert("banana")

    println(trie.search("apple"))  // true
    println(trie.search("app"))    // true
    println(trie.search("appl"))   // false

    println(trie.startsWith("ap")) // true
    println(trie.startsWith("ba")) // true
    println(trie.startsWith("ca")) // false
}
