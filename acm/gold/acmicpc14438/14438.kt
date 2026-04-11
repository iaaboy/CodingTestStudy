package acm.gold.acmicpc14438

import java.util.StringTokenizer

/* 수열과 쿼리 17, 세그먼트 트리
 https://www.acmicpc.net/problem/14438
 */

fun main() {

    fun getLen(input: Int): Int {
        var output = 1
        while (output < input) {
            output *= 2
        }
        return output
    }

    val N = readln().toInt()
    val len = getLen(N) * 2
    val tree = IntArray(len) { Int.Companion.MAX_VALUE }
    val dataStartIndex = len / 2
    val st = StringTokenizer(readln())
    for (i in dataStartIndex..<dataStartIndex + N) {
        tree[i] = st.nextToken().toInt()
    }

    var i = len - 1
    while (i >= 0) {
        tree[i / 2] = minOf(tree[i], tree[i - 1])
        i -= 2
    }

    fun printTree() {
//        println("curTree")
//        var level = 1
//        var index = 1
//        while (index < tree.size) {
//            val end = minOf(index + level, tree.size)
//            println(tree.slice(index until end).joinToString(" "))
//            index += level
//            level *= 2
//        }
    }

    printTree()

    fun getMin(s: Int, e: Int): Int {
        var s = s
        var e = e
        var min = Int.Companion.MAX_VALUE
        while (s <= e) {
            if (s % 2 == 1) {
                min = minOf(min, tree[s])
            }
            if (e % 2 == 0) {
                min = minOf(min, tree[e])
            }
            s = (s + 1) / 2
            e = (e - 1) / 2
        }
        return min
    }

    fun update(idx: Int, value: Int) {
        var i = idx + dataStartIndex - 1
        tree[i] = value  // 리프 갱신

        i /= 2
        while (i > 0) {
            tree[i] =
                minOf(tree[i * 2], tree[i * 2 + 1])
            i /= 2
        }
    }

    val M = readln().toInt()
    val sb = StringBuilder()
    repeat(M) {
        val st = StringTokenizer(readln())
        val q = st.nextToken().toInt()
        if (q == 1) {
            val i = st.nextToken().toInt()
            val v = st.nextToken().toInt()
            // Ai를 v로 바꾼다
            update(i, v)

            printTree()

        } else {
            val i = st.nextToken().toInt() - 1 + dataStartIndex
            val j = st.nextToken().toInt() - 1 + dataStartIndex
            //Ai, Ai+1, ..., Aj에서 크기가 가장 작은 값을 출력한다
            sb.append("${getMin(i, j)}\n")
        }
    }
    print(sb)
}
