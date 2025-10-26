package acmicpc24955

import java.io.*
import java.math.BigInteger
import java.util.*

/* 숫자 이어 붙이기
https://www.acmicpc.net/problem/24955
 */

lateinit var v: Array<Vertex>
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val Q = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    v = Array(N + 1) {
        if (it == 0) {
            Vertex(0, 0)
        } else {
            Vertex(st.nextToken().toLong(), it)
        }
    }

    repeat (N - 1) {
        val st = StringTokenizer(bf.readLine())
        val parent = st.nextToken().toInt()
        val son = st.nextToken().toInt()
        v[son].son.add(parent)
        v[parent].son.add(son)
    }

    setDepth(1, 1, 0)

    val lStack = ArrayDeque<Int>()
    val rStack = ArrayDeque<Int>()

    val sb = StringBuilder()
//    val debugSb = StringBuilder()

    repeat(Q) {
        val st = StringTokenizer(bf.readLine())
        var from = st.nextToken().toInt()
        var to = st.nextToken().toInt()

        //depth 맞춘다
        while (v[from].depth != v[to].depth) {
            if (v[from].depth > v[to].depth) {
                lStack.addLast(from)
                from = v[from].parent
            } else {
                rStack.addFirst(to)
                to = v[to].parent
            }
        }

        //공통 조상 찾는다.
        while (v[from].index != v[to].index) {
            lStack.addLast(from)
            rStack.addFirst(to)
            from = v[from].parent
            to = v[to].parent
        }
        lStack.addLast(v[from].index)
        lStack.addAll(rStack)

        val number = StringBuilder()
        while (lStack.isNotEmpty()) {
            val index = lStack.pollFirst()
//            debugSb.append(v[index].num).append("")
            number.append(v[index].num.toString())
        }
//        debugSb.append(v.contentToString())
//        debugSb.append("\n")

//        sb.append(number)
        val result = BigInteger(number.toString()).mod(BigInteger("1000000007"))
        sb.append(result).append("\n")
        lStack.clear()
        rStack.clear()
    }
//    println(debugSb)
    print(sb)
}

fun setDepth(parent: Int, c: Int, depth: Int) {
    v[c].depth = depth
    v[c].parent = parent
    for (son in v[c].son) {
        if (v[son].parent == -1)
            setDepth(c, son, depth + 1)
    }
}

data class Vertex(val num: Long, val index: Int) {
    var parent: Int = -1
    val son: ArrayList<Int> = ArrayList<Int>()
    var depth: Int = 0
    override fun toString(): String {
        return "num:$num p: $parent d:$depth, son: $son | "
    }
}