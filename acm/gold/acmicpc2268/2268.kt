package acm.gold.acmicpc2268

import java.util.StringTokenizer

/* 수들의 합 7, 세그먼트 트리, fenwick tree
https://www.acmicpc.net/problem/2268
이해에 도움을 주는 영상 : https://www.youtube.com/watch?v=fg2iGP4e2mc
 */

fun main() {
    val st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val arr = LongArray(N + 1)
    val fwt = FenwickTree(N)
    val sb = StringBuilder()

    repeat(M) {
        val st = StringTokenizer(readln())
        val cmd = st.nextToken().toInt()
        if (cmd == 0) { //sum i ~ j sum
            val i = st.nextToken().toInt()
            val j = st.nextToken().toInt()
            val l = minOf(i, j)
            val r = maxOf(i, j)
            sb.append(fwt.rangeSum(l, r)).append('\n')
        } else if (cmd == 1) { //modify  i의 값을 K로 변경
            val i = st.nextToken().toInt()
            val k = st.nextToken().toLong()
            val diff = k - arr[i]
            arr[i] = k
            fwt.update(i, diff)
        }

//        fwt.printTree1Based()
    }
    print(sb)
}

class FenwickTree(val n: Int) {
    private val tree = LongArray(n + 1)

    fun update(i: Int, diff: Long) {
        var idx = i
        while (idx <= n) {
            tree[idx] += diff
            idx += (idx and -idx)
        }
    }

    fun sum(i: Int): Long {
        var idx = i
        var res = 0L
        while (idx > 0) {
            res += tree[idx]
            idx -= (idx and -idx)
        }
        return res
    }

    fun rangeSum(l: Int, r: Int): Long {
        return sum(r) - sum(l - 1)
    }

    fun printTree1Based() {
        println()
        println("idx : " + (1..n).joinToString(" "))
        println("val : " + (1..n).joinToString(" ") { tree[it].toString() })
    }
}