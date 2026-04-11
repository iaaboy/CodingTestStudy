package acm.gold.acmicpc10868

import java.util.*

lateinit var tree: IntArray

/* 최솟값, 세그먼트 트리
 * https://www.acmicpc.net/problem/10868
 */

fun main() {
    val sb = StringBuilder()
    var st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val len = getLen(N) * 2
    tree = IntArray(len) { Int.Companion.MAX_VALUE }
    val dataStartIndex = len / 2
    for (i in dataStartIndex..<dataStartIndex + N) {
        tree[i] = readln().toInt()
    }
    run {
        var i = len - 1
        while (i >= 0) {
            tree[i / 2] = minOf(tree[i], tree[i - 1])
            i -= 2
        }
    }

//    System.out.println(Arrays.toString(tree));
//    println(tree.joinToString(" "))

//    var level = 1
//    var index = 1
//
//    while (index < tree.size) {
//        val end = minOf(index + level, tree.size)
//        println(tree.slice(index until end).joinToString(" "))
//        index += level
//        level *= 2
//    }

    repeat(M) {
        st = StringTokenizer(readln())
        val start = st.nextToken().toInt() - 1 + dataStartIndex
        val end = st.nextToken().toInt() - 1 + dataStartIndex
        sb.append(getMin(start, end)).append("\n")
    }

    print(sb)
}

private fun getMin(s: Int, e: Int): Int {
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

fun getLen(input: Int): Int {
    var output = 1
    while (output < input) {
        output *= 2
    }
    return output
}

fun update(idx: Int, value: Int) {
    var i = idx
    tree[i] = value  // 리프 갱신

    i /= 2
    while (i > 0) {
        tree[i] = minOf(tree[i * 2], tree[i * 2 + 1])
        i /= 2
    }
}
