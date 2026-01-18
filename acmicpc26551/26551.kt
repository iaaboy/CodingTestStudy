package acmicpc26551

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/* Family , Union find 분리 집합
https://www.acmicpc.net/problem/26551
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()

    ids = IntArray(2 * N) {
        it
    }

    val idMap = HashMap<String, Int>()
    var index = 0
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        val a = st.nextToken()
        st.nextToken()
        val c = st.nextToken()

        if (!idMap.containsKey(a)) {
            idMap.put(a, index++)
        }
        val idA = idMap.get(a) ?: 0
        if (!idMap.containsKey(c)) {
            idMap.put(c, index++)
        }
        val idC = idMap.get(c) ?: 0

        setUnion(idA, idC)
    }

    val M = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(M) {
        val st = StringTokenizer(bf.readLine())
        val a = st.nextToken()
        val c = st.nextToken()
        val idA = idMap.get(a) ?: 0
        val idC = idMap.get(c) ?: 0
        if (getUnion(idA) == getUnion((idC))) {
            sb.append("Related\n")
        } else {
            sb.append("Not Related\n")
        }
    }
    print(sb)
}


private lateinit var ids: IntArray

private fun getUnion(from: Int): Int {
    var f = from
    while (ids[f] != f) {
        f = ids[f]
    }

    if (from != f) { // key !!! Union find 의 while loop를 줄임
        ids[from] = f
    }

    return f
}

private fun setUnion(from: Int, to: Int) {
    var f = from
    while (ids[f] != f) {
        f = ids[f]
    }
    var t = to
    while (ids[t] != t) {
        t = ids[t]
    }
    if (f > t) {
        ids[f] = t
    } else {
        ids[t] = f
    }
}
